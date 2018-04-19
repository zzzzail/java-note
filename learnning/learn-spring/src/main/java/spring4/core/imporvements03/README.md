[Spring 文档链接](https://docs.spring.io/spring/docs/4.3.14.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/#v4_2-Core-Container-Improvements)

* Configuration classes may declare an `@Order` value, 
getting processed in a corresponding order (e.g. for overriding beans by name) 
even when detected through classpath scanning.

> 配置类可以声明一个`@Order`的值, 按照相对应的顺序进行处理(), 
支持对装载在诸如Lists和Arrays容器中的自动包装（auto-wired）组件的排序.

示例: 
```java
public interface RankService {
}

@Component
@Order(2)
public class RankServiceImpl01 implements RankService {
  @Override
  public String toString() {
    return "RankServiceImpl01";
  }
}

@Component
@Order(1)
public class RankServiceImpl02 implements RankService {
  @Override
  public String toString() {
    return "RankServiceImpl02";
  }
}

@Component
@Order(3)
public class RankServiceImpl03 implements RankService {
  @Override
  public String toString() {
    return "RankServiceImpl03";
  }
}

@Component
public class Results {

  @Autowired
  private List<RankService> rankService;

  @Override
  public String toString() {
    return rankService.toString();
  }
}

@Configuration
@ComponentScan
public class MainTest {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainTest.class);
    Results results = applicationContext.getBean(Results.class);
    // @Order 的值越小, 排序约靠前
    System.out.println(results); // [RankServiceImpl02, RankServiceImpl01, RankServiceImpl03]
  }

}
```