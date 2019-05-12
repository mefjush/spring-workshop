package pl.sda.kantor.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.kantor.order.CurrencyOrder;
import pl.sda.kantor.order.OrderRepository;
import pl.sda.kantor.rate.CurrencyCheckRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private CurrencyCheckRepository currencyCheckRepository;
    private OrderRepository orderRepository;

    public AdminController(CurrencyCheckRepository currencyCheckRepository, OrderRepository orderRepository) {
        this.currencyCheckRepository = currencyCheckRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/conversion/stats")
    public String getStats(Model model) {
        model.addAttribute("allChecksCount", currencyCheckRepository.count());
        model.addAttribute("eurChecksCount", currencyCheckRepository.countByCurrency("EUR"));
        model.addAttribute("mostPopular", currencyCheckRepository.getMostPopularCurrency());
        return "adminStats";
    }

    @GetMapping("/orders")
    public String getOrders(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "orders";
    }

    @PostMapping("/orders/confirm")
    public String confirmOrder(@RequestParam("orderId") int orderId) {
        CurrencyOrder order = orderRepository.findById(orderId).get();
        order.setConfirmed(true);
        orderRepository.save(order);
        return "redirect:/admin/orders";
    }
}
