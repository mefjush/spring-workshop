package pl.sda.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Map<String, String> provinces = getProvinces();

        System.out.println("Province codes: ");
        System.out.println(provinces);

        Map<String, Lottery> provinceLotteries = new HashMap<>();

        for (Map.Entry<String, String> province : provinces.entrySet()) {
            provinceLotteries.put(province.getKey(), new Lottery());
        }

        System.out.println("Enter province code: ");

        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            String code = sc.nextLine();
            Lottery lottery = provinceLotteries.get(code);
            if (lottery == null) {
                System.out.println("Wrong code, try again.");
            } else {
                String prize = lottery.getPrize();
                System.out.println("Your prize is: " + prize);
            }
        }
    }

    private static Map<String, String> getProvinces() {
        Map<String, String> provinces = new HashMap<>();
        provinces.put("02", "Dolnośląskie");
        provinces.put("04", "Kujawsko-Pomorskie");
        provinces.put("06", "Lubelskie");
        provinces.put("08", "Lubuskie");
        provinces.put("10", "Łódzkie");
        provinces.put("12", "Małopolskie");
        provinces.put("14", "Mazowieckie");
        provinces.put("16", "Opolskie");
        provinces.put("18", "Podkarpackie");
        provinces.put("20", "Podlaskie");
        provinces.put("22", "Pomorskie");
        provinces.put("24", "Śląskie");
        provinces.put("26", "Świętokrzyskie");
        provinces.put("28", "Warmińsko-Mazurskie");
        provinces.put("30", "Wielkopolskie");
        provinces.put("32", "Zachodniopomorskie");
        return provinces;
    }

}
