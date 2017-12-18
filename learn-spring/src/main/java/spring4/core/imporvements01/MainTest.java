package spring4.core.imporvements01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author zail
 * @version 0.0.imp01
 */
public class MainTest {

  @Bean
  public UserService userServiceFindUserById() {
    return new UserService() {
      public void findUserById(Integer id) {
        System.out.println(id);
      }
    };
  }

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainTest.class);
    UserService userService = (UserService) applicationContext.getBean(UserService.class);
    userService.findUserById(1);
  }
}
