package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "example")
public class SpringApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringApp.class);
        MyService myService = context.getBean(MyService.class);
        myService.sayHi();
    }

    // Sposób 1 na tworzenie komponentów zarządzanych przez Springa
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

}

