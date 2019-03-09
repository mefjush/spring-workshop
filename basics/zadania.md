0. Lottery - podstawy Springa
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
    
1. Kantor - Spring Boot 
    * Będziemy tworzyć aplikację kantoru wymiany walut.
    * W tym zadaniu posłużymy się projektem `Spring Boot`.
    * Wejdź na stronę https://start.spring.io/ i wygeneruj nowy projekt. 
    * Otwórz projekt w swoim IDE, upewnij się, że możesz go uruchomić.
    
2. Kantor - zasoby statyczne
    * Stwórz prostą stronę-wizytówkę. Z nazwą i adresem Twojego kantoru.
    * ???
    * (Opcjonalnie) Popracuj na wyglądem strony. W tym celu możesz użyć styli CSS.
    
3. Kantor - strony dynamiczne
    * Zamień swoją statyczną stronę na dynamiczną. Dodaj informację jaki mamy dziś dzień tygodnia i czy kantor jest dziś otwarty.
    * Użyj wzorca MVC. Zaimplemntuj widok przy użyciu ???.
    * ???
    * (Opcjonalnie) Do wyświetlenia informacji czy jest otwarte sprawdzaj nie tylko datę ale również godzinę.
    
4. Kantor - client http
    * Dodaj podstronę z dzisiejszym kursem walut.
    * Jako źródła danych użyj `https://api.exchangeratesapi.io/latest`. Dokumentację znajdziesz na stronie `https://exchangeratesapi.io/`.
    * Użyj klasy `RestTemplate` ze springa.
    * Sprawdź jakie metody ona oferuje.
    * (Opcjonalnie) W tabelce zamieść 2 kursy: kupna i sprzedaży.
    
6. Kantor - formularz
    * Dodaj podstronę z formularzem do przeliczania walut. 
    * Daj użytkownikowi możliwość wybrania kwoty, waluty i waluty docelowej. 
    * Przelicz podaną kwotę i wyświetl uzytkownikowi.
    
6. Kantor - db / data
    * Dla celów statystycznych chcemy zbierać dane o tym jakie kwoty i waluty przeliczają nasi odwiedzający.
    * Zapisuj zebrane dane do bazy daych. 
    * Przygotuj podstronę ze statystykami, np:
        * Wyświetl jaka jest najpopularniejsza konwertowana walutę.
        * Jaka jest średnia przeliczana kwota. 
        * Suma wszystkich przeliczeń z PLN.
    
    * ??? jdbc + sth else

    
5. Kantor - testowanie
7. Kantor - integration
8. Kantor - web flow
9. Kantor - security
