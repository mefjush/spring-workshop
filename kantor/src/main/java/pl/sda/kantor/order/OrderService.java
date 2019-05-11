package pl.sda.kantor.order;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void submitOrder(String currency, Double value) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        CurrencyOrder currencyOrder = new CurrencyOrder(currency, value, username);
        orderRepository.save(currencyOrder);
    }
}
