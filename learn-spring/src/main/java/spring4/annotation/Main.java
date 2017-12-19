package spring4.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring4.annotation.controller.UserController;

/**
 * @author zail
 * @since 2017-12-19
 */
@ComponentScan
public class Main {
  
  public static void main(String[] args) {
  
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
    TestObject testObject = ctx.getBean(TestObject.class);
    System.out.println(testObject);
  
    UserController userController = (UserController) ctx.getBean("userController");
    userController.execute();
    
  }
  
}
