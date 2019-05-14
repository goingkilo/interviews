package aop;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class WelcomeAdvice implements MethodBeforeAdvice {
    public void before(Method method, Object[] args, Object target) {

        Customer customer = (Customer) args[0];

        System.out.println("Hello " + customer.getName() +
                ". How are you doing?");

    }
}
