package example;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Sposób 2 na tworzenie komponentów zarządzanych przez Springa
@Service
public class MyService {

    private final MyComponent myComponent;
    private final MyBean myBean;

    @Autowired
    public MyService(MyComponent myComponent, MyBean myBean) {
        this.myComponent = myComponent;
        this.myBean = myBean;
    }

    public void sayHi() {
        System.out.println("Hello from MyService!");
        myComponent.sayHi();
        myBean.sayHi();
    }
}
