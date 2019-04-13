package pl.sda.kantor.rate;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeRatesService {

    private static class ExchangeRates {
        //TODO dodać pola które odpowiadają zawartości z pod linku
        
    }

    // https://api.exchangeratesapi.io/latest?base=PLN

    private RestTemplate restTemplate;

    //TODO zadeklarowac Bean w KantorApplication
    public ExchangeRatesService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Rate> getRates() {
        ExchangeRates exchangeRates = restTemplate.getForObject("https://api.exchangeratesapi.io/latest?base=PLN", ExchangeRates.class);

        //TODO skonstruować listę Rates na podstawie zawartości ExchangeRates

        return new ArrayList<>();
    }
}
