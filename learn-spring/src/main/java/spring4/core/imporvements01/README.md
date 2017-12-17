[Spring 文档链接](https://docs.spring.io/spring/docs/4.3.14.BUILD-SNAPSHOT/spring-framework-reference/htmlsingle/#v4_2-Core-Container-Improvements)

* Annotations such as `@Bean` get detected and processed on Java 8 default methods as well, 
allowing for composing a configuration class from interfaces with default `@Bean` methods.

> `@Bean` 注解可以检查和执行 Java 8 默认方法(as well), 允许为一个接口装载一个实例化对象(使用类内部的方法).

示例: 

```java
public interface UserService() {
  void findUserById(Integer id);
}
```

```java
public Main() {
  // 使用注解为 Service 装载实例 
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
    UserService userService = applicationContext.getBean(UserService.class);
    userService.findUserById(1);
  }
}
```