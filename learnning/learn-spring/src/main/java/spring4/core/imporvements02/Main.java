package spring4.core.imporvements02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author zail
 * @version 0.0.1
 */
@Configuration
@Import(value = {ComponentClass.class})
public class Main {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
    ComponentClass component = applicationContext.getBean(ComponentClass.class);
    component.print();
  }

}
