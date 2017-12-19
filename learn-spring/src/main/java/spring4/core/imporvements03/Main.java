package spring4.core.imporvements03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author zail
 * @version 0.0.1
 */
@Configuration
@ComponentScan
public class Main {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
    Results results = applicationContext.getBean(Results.class);
    System.out.println(results);
  }

}
