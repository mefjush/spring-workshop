package example;


import org.springframework.stereotype.Component;

// Sposób 2 na tworzenie komponentów zarządzanych przez Springa
@Component
public class MyComponent {

    public void sayHi() {
        System.out.println("Hi there from MyComponent!");
    }
}
