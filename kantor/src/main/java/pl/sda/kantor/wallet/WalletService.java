package pl.sda.kantor.wallet;

import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private final WalletRepository walletRepository;

    public WalletService(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    public synchronized void add(String currency, Double value) {
        WalletEntry walletEntry = new WalletEntry();
        walletEntry.setCurrency(currency);
        walletEntry.setChange(value);
        walletRepository.save(walletEntry);
    }

    public synchronized void subtract(String currency, Double value) {
        Double walletAmount = walletRepository.getWalletAmount(currency);
        if (value > walletAmount) {
            throw new RuntimeException("Not enough money to subtract " + value + " " + currency);
        }
        WalletEntry walletEntry = new WalletEntry();
        walletEntry.setCurrency(currency);
        walletEntry.setChange(-value);
        walletRepository.save(walletEntry);
    }
}
