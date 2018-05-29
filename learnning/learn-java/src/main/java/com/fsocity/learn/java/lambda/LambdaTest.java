package com.fsocity.learn.java.lambda;

/**
 * @author zail
 * @since 2018-05-29
 */
public class LambdaTest {
    
    public static void main(String[] args) {
        ServiceInvoker<UserService> serviceInvoker =
            new DefaultServiceInvoker<>(new UserService());
    
        String name = serviceInvoker.invoke((service) -> {
            return service.findName(1L);
        });
        System.out.println(name);
    }
}
