package pl.sda.spring;

import java.util.*;

public class App {

    private static final List<String> COUNTRIES = Arrays.asList("PL", "DE", "BE", "US", "CZ", "SK", "RU");
    private static final String PROMPT_MSG = "Enter your country code to draw a prize...";

    public static void main(String[] args) {

        Map<String, Lottery> countryLotteries = new HashMap<>();

        for (String countryCode : COUNTRIES) {
            countryLotteries.put(countryCode, new Lottery(countryCode));
        }

        System.out.println(PROMPT_MSG);
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String code = sc.nextLine().toUpperCase();
            Lottery lottery = countryLotteries.get(code);
            if (lottery == null) {
                System.out.println("Unrecognized country code, supported codes: " + COUNTRIES);
            } else {
                System.out.println("Your prize is: " + lottery.getPrize());
            }
            System.out.println(PROMPT_MSG);
        }
    }
}
