package pl.sda.lottery;

import example.MyService;
import example.SpringApp;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
@ComponentScan(basePackages = "pl")
public class App {

//    public static void main(String[] args) {
//        LotteryRunner lotteryRunner = new LotteryRunner();
//        lotteryRunner.run();
//    }

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        LotteryRunner lotteryRunner = context.getBean(LotteryRunner.class);
        lotteryRunner.run();
    }

    @Bean
    public SecureRandom secureRandom() {
        return new SecureRandom();
    }
}
