[Spring 文档链接](https://docs.spring.io/spring/docs/4.3.14.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/#v4_2-Core-Container-Improvements)

* Configuration classes may declare @Import with regular component classes now, 
allowing for a mix of imported configuration classes and component classes.

> 配置类可使用`@Import`导入单个或多个常规的组件类, 允许一个导入混合的配置类和组件类.

示例: 
```java
@Component
public class ComponentClass {

  public void print() {
    System.out.println("ComponentClass");
  }

}
```
```java
@Configuration
@Import(value = {ComponentClass.class, ...})
public class MainTest {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainTest.class);
    ComponentClass component = applicationContext.getBean(ComponentClass.class);
    component.print();
  }

}
``` 