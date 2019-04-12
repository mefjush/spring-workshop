0. Lottery - podstawy Springa
    0. Zaimportuj projekt na zajęcia 
        * `git clone https://github.com/mefjush/spring-workshop`
        * `Idea -> File -> Open -> Wybierz plik pom.xml -> Open as Project`
        
    1. Wstęp
        * Uruchom aplikację Loterii za pomocą klasy `App`. Zwróć uwagę na czas startu aplikacji. Co na niego wpływa?
        * Zamień klasę `LotteryRunner` na Bean. Zamień `App` na aplikację Springową. Przykład znajedziesz w pakiecie `example`.
        * Zamień kolejne zależności na obiekty zarządzane przez springa. Uruchom i sprawdź czy działa.
    
    2. Rozwinięcie
        * Dodaj kolejny typ Loterii - gdzie zawsze wygrywa się długopis. Uruchom i sprawdź czy działa.
        * Za każdym razem gdy ktoś kupuje losy na loterię za > 500zł - powiadom urząd podatkowy (klasa `TaxOffice`) o dużej transakcji.
        * Upewnij się, że aplikacja tworzy teraz minimalną ilość wymaganych obiektów.
        
    3. Zakończenie
        * Załóżmy jednak, że nie chcemy by nasz `RandomNumberGenerator` był singletonem. Chcemy posiadać wiele instancji tej klasy. Wprowadź zmianę przy pomocy adnotacji `@Scope`. 
        * (Opcjonalnie) Wymyśl własny typ loterii i dodaj go do aplikacji.
        * (Opcjonaline) Dodaj klasę `Committee` reprezentującą Komisję Kontroli Gier i Zakładów. Powiadom komisję o wyniku każdego głosowania. 
    
1. Kantor - Spring Boot 
    * Będziemy tworzyć aplikację kantoru wymiany walut.
    * W tym zadaniu posłużymy się projektem `Spring Boot`.
    * Wejdź na stronę https://start.spring.io/ i wygeneruj nowy projekt. (Zależność którą warto zaznaczyć na początek: web)
    * Otwórz projekt w swoim IDE, upewnij się, że możesz go uruchomić.
    * Opcjonalnie projekt można również uruchomić z linii komend `mvn spring-boot:run`
    
2. Kantor - zasoby statyczne
    * Stwórz prostą stronę-wizytówkę. Z nazwą i adresem Twojego kantoru.
    * W tym celu stwórz plik index.html w katalogu `src/main/resources/static`
    * Popracuj na wyglądem strony. W tym celu użyj styli CSS.
    * (Opcjonalnie) Dodaj zdjęcie lokalu/własciciela.
    * (Opcjonalnie) Dodaj mapę z dojazdem. (Google maps -> Wybierz miejsce -> Embed)
    
3. Kantor - strony dynamiczne
    * Dodaj podstronę `/contact`. Tym razem będzie to strona dynamiczna. Dodaj informację jaki mamy dziś dzień tygodnia i czy kantor jest dziś otwarty.
    * Zacznij od prostego rozwiązania i zwróć prosty napis.
    * Gotowe? Teraz zmodyfikuj swoje rozwiązanie tak aby używało wzorca MVC. 
    * Użyjemy Thymeleaf jako silnika widoku. W tym celu dodaj do mavena zależność `spring-boot-starter-thymeleaf`.
    * (Opcjonalnie) Do wyświetlenia informacji czy jest otwarte sprawdzaj nie tylko datę ale również godzinę.
    * Wskazówki: 
       * Restarty aplikacji zajmują zbyt długo? Dodaj zależność `spring-boot-devtools` do mavena.
       * Dokumentacja: https://spring.io/guides/gs/serving-web-content/
    
4. Kantor - strony dynamiczne - model
    * Dodaj podstronę z dzisiejszym kursem walut (na początek wystarczy EUR, USD i CHF). 
    * Stwórz klasę `Rate`, która będzie reprezentować kurs wymiany waluty - będzie to Twój Model
    * Stwórz podstronę `/rates` która wyświetli aktualne kursy wymiany - korzystając z klasy `Rate`
    
5. Kantor - strony dynamiczne - http client
    * Spraw aby Twoje kursy walut były dynamiczne.
    * Jako źródła danych użyj `https://api.exchangeratesapi.io/latest`. Dokumentację znajdziesz na stronie `https://exchangeratesapi.io/`.
    * Użyj klasy `RestTemplate` ze springa.
    * Sprawdź jakie metody ona oferuje.
    * (Opcjonalnie) W tabelce zamieść 2 kursy: kupna i sprzedaży.
    
6. Kantor - formularz
    * Dodaj podstronę z formularzem do przeliczania walut. 
    * Daj użytkownikowi możliwość wybrania kwoty, waluty i waluty docelowej. 
    * Przelicz podaną kwotę i wyświetl uzytkownikowi.
    * (Opcjonalnie) Co gdy użytkownik poda nieprawidłową wartość? Wyświetl komunikat stosowny komunikat.
    
7. Kantor - rozszerzanie template'ów
    * Twoja strona ma już kilka podstron - chcielibyśmy móc łatwo w niej nawigować.
    * W katalogu `templates/fragments` dodaj `layout.html` - Twój ogólny zarys strony.
    * Do stworzonego pliku dodaj nazwę strony i proste menu. Oznacz je jako `th:fragment="header"`
    * W pozostałych widokach użyj zdefiniownego fragmentu np. `<div th:replace="fragments/layout :: header"></div>`
    * Zmień widok każdej z podstron tak aby używał tego fragmentu.
 
8. Kantor - config
    * Niestety ale kantor to nie instytucja charytatywna. 
    * Uaktualnij swój projekt tak aby każdy kurs wymiany walut był powiększony o prowizję
    * Lista kursów wymiany powinna zawierać teraz dwie wartości - kurs kupna i sprzedaży
    * Ustawiaj wartość prowizji (spread) w pliku konfiguracyjnym `application.properties`
    
9. Kantor - db / data
    * Dla celów statystycznych chcemy zbierać dane o tym jakie kwoty i waluty przeliczają nasi odwiedzający.
    * Zapisuj zebrane informacje w bazie danych MySQL.
    * Dodaj do mavena zależność `spring-boot-starter-data-jpa`
    * Uruchom aplikację
    * Jakiś problem? Dodaj wymaganą konfigurację bazy danych:
         ```
         spring.datasource.url=jdbc:mysql://localhost:3306/db_example
         spring.datasource.username=???
         spring.datasource.password=???
         ```
    * Do zapisywania stwórz repozytorium korzystające z `JdbcTemplate`.
    * Przygotuj podstronę ze statystykami `/admin/convertion/stats`, tym razem przy pomocy repozytorium rozszerzającego `CrudRepository<?, Integer>`
        * Wyświetl jaka jest najpopularniejsza konwertowana waluta.
        * Jaka jest średnia przeliczana kwota. 
        * Suma wszystkich przeliczeń z PLN.
    
10. Kantor - test
    * Napisz test integracyjny dla repozytoriów stworzonych w poprzednim zadaniu.
    * Przetestuj czy możesz zapisać a następnie odczytać dane z bazy danych.
    * Sprawdź zawartość bazy danych po kilkukrotnym uruchomieniu testu. Jakieś spostrzeżenia?
    * Wymuś rollback zawartości bazy danych po każdym teście. Użyj adnotacji `@Transactional`.
    
11. Kantor - security 
    * Nowo dodana podstrona zawiera dość wrażliwe dane.
    * Zabezpiecz dostęp do niej przy pomocy spring security.
    * Dodaj zależność `spring-boot-starter-security` i uruchom aplikację. Co się stało?
    * Wyłącz zabezpieczenia dla podstron które tego nie wymagają.
    
12. Kantor - wymiana walut
    * Dodaj do swojej strony możliwość złożenia zamówienia na transakcję wymiany walut.
    * Użytkownik wprowadza kwotę, walutę oraz walutę docelową, sprawdza ile pieniędzy otrzyma a następnie ma możliwość złożenia zamówienia.
    * Nowe zamówienie dodawane jest do bazy danych. 
    
13. Kantor - authorization
    * Ogranicz możliwość składania zamówienia tylko zarejestrowanym użytkownikom.
    * Stwórz w systemie 2 użytkowników: `user` oraz `admin`
    * Zarówno zwykły użytkownik jak i admin mogą składać zamówienia
    * Tylko admin ma dostęp do `/admin/convertion/stats`
    * Dodaj do menu informację kto jest zalogowany.
    
14. Kantor - authentication (oauth)
    * Wprowadź mechanizm autentykacji za pomocą konta Google.
    * Zarejestruj swoją aplikację tutaj: https://console.developers.google.com/
    * Zapisz wygenerowane dane dostępowe
    * Skonfiguruj aplikację aby używała konta Google jako metody autentykacji.
    * Sprawdź czy użytkownik zalogowany ma prawidłowy dostęp do wszystkich podstron.
    * Wskazówki: https://www.baeldung.com/spring-security-5-oauth2-login

15. Kantor - transakcje
    * Zaprojektuj podstronę administratora, która wyświetli wszystkie zamówienia.
    * Obok zamówienia umieść przycisk "Zrealizuj", który oznaczy zamówienie jako zrealizowane.
    * Zaprojektuj tabelę `wallet`, która reprezentuje stan konta (portfel) kantoru.
    * Uaktualniaj tabelę `wallet` podczas realizacji zamówienia. 
    * Co zrobisz jeśli w portfelu brakuje pieniędzy na realizację zamówienia?
    * Zabezpiecz metodę "realizacji zamówienia" adnotacją `@PreAuthorize` - pozwalającą na wywołanie tej metody tylko użytkownikom posiadających rolę `ADMIN`

16. Kantor - web flow
    * Składanie zamówień działa ale ma pewną wadę.
    * Co się stanie gdy kilka razy odświeżysz stronę zamówienia?
    * Zaprojektuj "idiotoodporne" rozwiązanie problemu przy pomocy Spring Web Flow

17. Kantor - json api
    * W internecie pojawiła się _Porównywarka Kantorów™_ 
    * Aby nie stracić potencjalnych klientów chcemy udostępnić nasze kursy dla _Porównywarki Kantorów™_ 
    * W tym celu dodaj endpoint `/api/exchange/rates/PLN` który zwóci json z aktualnymi kursami
    * Zwracany obiekt powinien mieć postać: 
        ```
        {
          "eur": {
            "sell": 4.5,
            "buy": 4.2
          },
          "usd": {
            "sell": 3.9,
            "buy": 3.7
          }
        }
        ```

19. Kantor - chatbot
    * W ramach swojej aplikacji stwórz chatbota, który połączy się z chatem na stronie http://spring-ws-chat.herokuapp.com/
    * Gdy ktoś napisze `!kantor toEUR 10` chatbot powinien odpowiedzieć wiadomością z aktualną ofertą wymiany, np. `2.5 EUR` 
    
20. Kantor - integration
    * Zaprojektuj przy pomocy Spring Integration następujący scenariusz
    * Za każdym razem gdy ktoś wykona rezerwację na sumę > 1000 PLN wyślij maila do administratora
    * (Opcjonalnie) Oprócz wysłania maila dodatkowo odtwarzaj fanfary.

21. (Opcjonalnie) Kantor - integration
    * Zaprojektuj przy pomocy Spring Integration następujący scenariusz
    * Kantor powinien śledzić kurs wymiany walut. Jeżeli kurs spadnie o ponad 10% w krótkim odstępie czasu - jest to sytuacja alarmowa.
    * W takim wypadku powinien zostać wysłany mail do administratora.
    * (Opcjonalnie) Jeżeli zmiana nastąpi o ponad 20% wstrzymaj możliwość przeprowadzania jakichkolwiek transakcji w swoim systemie.
    * (Opcjonalnie) Pobieraj dane o kursie walut z 2 różnych źródeł. Jeśli różnica kursowa wynosi ponad 1% zwiększ pobieraną prowizję o 1.5%.

22. Wyświetlaj miłą dla oka stronę z informacją o błędzie, gdy w Twojej aplikacji wystąpi błąd.

23. (Opcjonalnie) Lombard
    * Twój kantor rozszerza działalność. Dodaj podstronę z usługami lombardu.
    * Wyświetlaj listę oferowanych na sprzedaż przedmiotów wraz z cenami.
    * Daj administratorowi możliwość zaznaczenia przedmiotu jako sprzedanego. 
    * Dodaj formularz wyceny. Pobieraj nazwę i opis przedmiotu oraz dane kontaktowe.
    * Wyświetlaj listę próśb o wycenę tylko adminowi.
    * Daj możliwość odpowiedzi na prośbę o wycenę. Np. "Za ten telefon oferuję 150zł"
    * Wystawiaj przedmioty na sprzedaż dopiero po 30 dniach od przyjęcia w zastaw.
