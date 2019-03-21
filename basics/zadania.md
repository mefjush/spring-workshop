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
    * Dodaj podstronę /contact. Tym razem będzie to strona dynamiczna. Dodaj informację jaki mamy dziś dzień tygodnia i czy kantor jest dziś otwarty.
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
    
8. Kantor - db / data
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
    * Przygotuj podstronę ze statystykami, tym razem przy pomocy repozytorium rozszerzającego `CrudRepository<?, Integer>`
        * Wyświetl jaka jest najpopularniejsza konwertowana waluta.
        * Jaka jest średnia przeliczana kwota. 
        * Suma wszystkich przeliczeń z PLN.
    
9. Kantor - security 
    * Nowo dodana podstrona zawiera dość wrażliwe dane.
    * Zabezpiecz dostęp do niej przy pomocy spring security.
    * Dodaj zależność `spring-boot-starter-security` i uruchom aplikację. Co się stało?
    * 

5. Kantor - testowanie
7. Kantor - integration
8. Kantor - web flow
9. Kantor - security
10. Kantor - transakcje db
11. Kantor wystaw json api dla porównywarki ofert kantorów

10. Bonus chatbot?