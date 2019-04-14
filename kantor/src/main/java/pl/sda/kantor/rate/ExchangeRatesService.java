package pl.sda.kantor.rate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ExchangeRatesService {

    private static final String URL = "https://api.exchangeratesapi.io/latest?base=PLN";

    private static class ExchangeRatesDto {
        //TODO dodać pola które odpowiadają zawartości z pod linku

        public String base;
        //pole które jest mapą String -> Double
        public Map<String, Double> rates;

    }

    private RestTemplate restTemplate;

    public ExchangeRatesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Rate> getRates() {
        ExchangeRatesDto exchangeRates = restTemplate.getForObject(URL, ExchangeRatesDto.class);

        //TODO skonstruować listę Rates na podstawie zawartości ExchangeRates
        //pętla for po mapie w exchangeRates która stworzy listę Rate

        ArrayList<Rate> rates = new ArrayList<>();

        for (Map.Entry<String, Double> entry : exchangeRates.rates.entrySet()) {
            String currency = entry.getKey();//skrót waluty np EUR
            Double exchangeRate = entry.getValue();//kurs 0.3524161137,

            //TODO stworzyć obiekt Rates i dodać do zwracanej listy

            Rate rate = new Rate(currency, exchangeRate);

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
