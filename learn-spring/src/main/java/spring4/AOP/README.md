# AOP 面向切面编程

### spring 中使用 AspectJ 实现面向切面编程

1. 引入 spring-aspects 包
2. 配置 @EnableAspectJAutoProxy, 自动为匹配的类生成代理对象
3. 把横切关注点的代码抽象到切面类中
  * 切面首先是一个IOC容器中的Bean, 即加入@Component注解
  * 切面需要加入@Aspect注解
4. 在类中声明各种通知:
  * AspectJ 中有5中通知注解
  * @Before: 前置通知, 在方法执行之前执行.
  * @After: 后置通知, 在方法执行之后执行.
  * @AfterReturning: 返回通知, 在方法返回结果之后执行.
  * @AfterThrowing: 异常通知, 在方法抛出异常之后执行.
  * @Around: 环绕通知, 围绕着方法执行.
