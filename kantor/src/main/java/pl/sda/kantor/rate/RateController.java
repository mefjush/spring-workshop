package pl.sda.kantor.rate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class RateController {

    private ExchangeRatesService exchangeRatesService;
    private CurrencyCheckRepository currencyCheckRepository;

    public RateController(ExchangeRatesService exchangeRatesService, CurrencyCheckRepository currencyCheckRepository) {
        this.exchangeRatesService = exchangeRatesService;
        this.currencyCheckRepository = currencyCheckRepository;
    }

    @GetMapping("/rates")
    public String getRates(Model model) {
        List<Rate> rates = exchangeRatesService.getRates();
        model.addAttribute("rates", rates);
        return "rates";
    }

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @PostMapping("/calculator")
    public String calculationResult(
            Model model,
            @RequestParam("currency") String currency,
            @RequestParam("value") Double value) {
        
        //TODO odczytaj parametry przekazane przez użytkownika
        System.out.println(currency);
        System.out.println(value);
        //TODO wyświetl dane przekazane przez użytkownika na stronie, np. 50 EUR = ???
        //TODO na podstawie danych od użytkownika przelicz ile PLN dostanie, np 50 EUR = 250 PLN

        Rate rate = exchangeRatesService.getRate(currency);
        Double convertedValue = value / rate.getRate();

        CurrencyCheck currencyCheck = new CurrencyCheck();
        currencyCheck.setAmount(value);
        currencyCheck.setCurrency(currency);
        currencyCheck.setTimestamp(new Date().getTime());
        currencyCheckRepository.save(currencyCheck);

        
        model.addAttribute("currency", currency);
        model.addAttribute("value", value);
        model.addAttribute("convertedValue", convertedValue);

        return "calculationResult";
    }
}
