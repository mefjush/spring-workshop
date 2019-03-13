Minimal Spring dependencies

```
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.1.0.RELEASE</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>5.1.0.RELEASE</version>
</dependency>

<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.1.0.RELEASE</version>
</dependency>
```

Scenario:

1. Easy task for spring core
2. Create a generated empty web app
3. Add static resources
4. Something dynamic directly: display a date / is it open (weekend/not)
5. Something dynamic over mvc: display a date, add some extra data
6. Consume a json endpoint and display the data 
     * raw
     * parse the json
7. Form - currency converter enter PLN get EUR value
8. Data - store what do people convert (TODO: prepare a table schema)
     * Prepare a page to query the data
     * Max converted amount, avg, top 5 currencies,
     * JDBC
     * Spring-magic
9. Auth - logged in user gets a better exchange rate (built in login? google?)
10. Security 
     * Add an option to order a money exchange
     * Only logged in user can make an order

19. Integration ?
     * Send an e-mail on money order?
20. bunus? war/tomcat deployments