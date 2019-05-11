package pl.sda.kantor.order;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.sda.kantor.rate.ExchangeRatesService;
import pl.sda.kantor.rate.Rate;
import pl.sda.kantor.wallet.WalletService;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ExchangeRatesService exchangeRatesService;
    private final WalletService walletService;

    public OrderService(OrderRepository orderRepository, ExchangeRatesService exchangeRatesService, WalletService walletService) {
        this.orderRepository = orderRepository;
        this.exchangeRatesService = exchangeRatesService;
        this.walletService = walletService;
    }

    public void submitOrder(String currency, Double value) {
        Rate rate = exchangeRatesService.getRate(currency);
        submitOrder(currency, value, rate.getSellRate());
    }

    public void submitOrder(String currency, Double value, Double rate) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        CurrencyOrder currencyOrder = new CurrencyOrder(currency, value, username, rate);
        orderRepository.save(currencyOrder);
        walletService.add("PLN", value * rate);
        walletService.subtract(currency, value);
    }
}
