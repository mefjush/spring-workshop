package pl.sda.kantor.order;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @PostMapping("/order")
    public String submitOrder(
            Model model,
            @RequestParam("currency") String currency,
            @RequestParam("value") Double value) {

        orderService.submitOrder(currency, value);

        return "orderSubmitted";
    }

}
