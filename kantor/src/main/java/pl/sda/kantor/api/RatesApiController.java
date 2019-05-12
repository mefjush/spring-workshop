package pl.sda.kantor.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.kantor.rate.ExchangeRatesService;
import pl.sda.kantor.rate.Rate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RatesApiController {

    private ExchangeRatesService exchangeRatesService;

    public RatesApiController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/api/exchange/rates/PLN")
    public Map<String, BuySell> exportedRates() {
        Map<String, BuySell> exportedRates = new HashMap<>();
        List<Rate> rates = exchangeRatesService.getRates();
        for (Rate rate : rates) {
            exportedRates.put(rate.getName(), new BuySell(rate));
        }
        return exportedRates;
    }
}
