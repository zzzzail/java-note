package spring4.generic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import spring4.generic.service.UserService;

/**
 * @author zail
 * @since 2017-12-20
 */
@ComponentScan
public class Main {
  
  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
    UserService userService = ctx.getBean(UserService.class);
    userService.add();
    userService.save();
  }
  
}
