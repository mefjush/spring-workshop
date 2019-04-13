package pl.sda.kantor.rate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class RateController {

    private ExchangeRatesService exchangeRatesService;

    public RateController(ExchangeRatesService exchangeRatesService) {
        this.exchangeRatesService = exchangeRatesService;
    }

    @GetMapping("/rates")
    public String getRates(Model model) {
        List<Rate> rates = exchangeRatesService.getRates();
        model.addAttribute("rates", rates);
        return "rates";
    }
}
