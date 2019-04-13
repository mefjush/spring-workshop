package pl.sda.kantor.rate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeRatesService {

    private static final String URL = "https://api.exchangeratesapi.io/latest?base=PLN";

    private static class ExchangeRates {
        //TODO dodać pola które odpowiadają zawartości z pod linku
        
    }

    private RestTemplate restTemplate;

    public ExchangeRatesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Rate> getRates() {
        ExchangeRates exchangeRates = restTemplate.getForObject(URL, ExchangeRates.class);

        //TODO skonstruować listę Rates na podstawie zawartości ExchangeRates

        return new ArrayList<>();
    }
}
