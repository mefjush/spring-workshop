package pl.sda.kantor.rate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeRatesService {

    private static final String URL = "https://api.exchangeratesapi.io/latest?base=PLN";

    private static class ExchangeRatesDto {
        //pole które jest mapą String -> Double
        public Map<String, Double> rates;
    }

    private RestTemplate restTemplate;
    private double spread;

    public ExchangeRatesService(RestTemplate restTemplate, @Value("${spread.percent:1}") double spread) {
        this.restTemplate = restTemplate;
        this.spread = spread;
    }

    public List<Rate> getRates() {
        ExchangeRatesDto exchangeRates = restTemplate.getForObject(URL, ExchangeRatesDto.class);

        ArrayList<Rate> rates = new ArrayList<>();

        for (Map.Entry<String, Double> entry : exchangeRates.rates.entrySet()) {
            String currency = entry.getKey();//skrót waluty np EUR
            Double exchangeRate = entry.getValue();//kurs 0.3524161137,

            Rate rate = new Rate(currency, exchangeRate, spread);

            rates.add(rate);
        }

        return rates;
    }

    public Rate getRate(String currency) {
        List<Rate> rates = getRates();
        for (Rate rate: rates) {
            if (rate.getName().equals(currency)) {
                return rate;
            }
        }
        return null;
    }
}
