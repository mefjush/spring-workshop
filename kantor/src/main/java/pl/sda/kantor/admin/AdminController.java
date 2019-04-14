package pl.sda.kantor.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.kantor.rate.CurrencyCheckRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private CurrencyCheckRepository currencyCheckRepository;

    public AdminController(CurrencyCheckRepository currencyCheckRepository) {
        this.currencyCheckRepository = currencyCheckRepository;
    }

    @GetMapping("/conversion/stats")
    public String getStats(Model model) {
        model.addAttribute("allChecksCount", currencyCheckRepository.count());
        model.addAttribute("eurChecksCount", currencyCheckRepository.countByCurrency("EUR"));
        model.addAttribute("mostPopular", currencyCheckRepository.getMostPopularCurrency());
        return "adminStats";
    }

}
