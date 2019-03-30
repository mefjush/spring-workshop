package com.sda.kantor;

import com.sda.kantor.weather.Weather;
import com.sda.kantor.weather.WeatherService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.aggregator.CorrelationStrategy;
import org.springframework.integration.aggregator.MessageCountReleaseStrategy;
import org.springframework.integration.aggregator.MessageGroupProcessor;
import org.springframework.integration.core.MessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;
import org.springframework.integration.handler.GenericHandler;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;

import java.util.ArrayList;

@Configuration
public class IntegrationConfig {

    @Bean
    public IntegrationFlow weatherChecker(WeatherService weatherService) {
        MessageSource<Weather> wroclawWeather = () -> {
            Weather weather = weatherService.getWeather("Wroclaw", "C");
            return new GenericMessage<>(weather);
        };

        MessageGroupProcessor temperatureDiff = messageGroup -> {
            ArrayList<Message<?>> messages = new ArrayList<>(messageGroup.getMessages());
            if (messages.size() < 2) {
                return 0;
            }
            Weather weather1 = (Weather) messages.get(0).getPayload();
            Weather weather2 = (Weather) messages.get(1).getPayload();
            int diff = weather1.getTemperature() - weather2.getTemperature();
            return (100 * diff) / weather1.getTemperature();
        };

        CorrelationStrategy weatherCorrelation = message -> {
            Weather weather = (Weather) message.getPayload();
            return weather.getLocationName();
        };

        GenericHandler<Integer> highDiffHandler = (diff, messageHeaders) -> {
            System.out.println("High weather diff: " + diff);
            return null;
        };

        return IntegrationFlows.from(wroclawWeather, configurer -> configurer.poller(Pollers.fixedDelay(2000)))
                .aggregate(aggregatorSpec -> aggregatorSpec
                        .outputProcessor(temperatureDiff)
                        .correlationStrategy(weatherCorrelation)
                        .releaseStrategy(new MessageCountReleaseStrategy(2))
                        .expireGroupsUponCompletion(true)
                )
                .filter(diff -> Math.abs((Integer) diff) > 1)
                .handle(highDiffHandler)
                .get();
    }
}
