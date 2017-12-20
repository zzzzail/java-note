# spring 注解

* 组件扫描(component scanning): spring 能够从classpath下自动扫描, 侦测和实例化具有特定注解的组件.
* 特定注解包括:
  * @Component: 基本注解, 标识一个受spring管理的组件.
  * @Repository: 标识持久层组件
  * @Service: 标识服务层(业务层)组件
  * @Controller: 标识在表现层组件
* 对于扫描到的组件, spring 有默认的命名策略: 使用非限定类名, 第一个字母小写. 也可以在注解中通过value属性值标识组件的名称.

* AutowiredAnnotationBeanPostProcessor: 自动装配具有@Autowired、@Resource、@Inject注解的属性.
* @Autowired 注解自动装配具有兼容类型的当Bean属性.
  * 构造器, 普通字段(即使是非public的), 一切具有参数的方法都可以应用@Autowired注解.
  * 默认情况下, 所有是使用@Autowired注解的属性都需要被设置, 当spring找不到匹配的Bean装配属性时, 会抛出异常, 
  若某一属性允许不被设置, 可以设置@Autowired注解的require参数为false.
  * 默认情况下当IOC容器里存在多个类型兼容的Bean时, 通过类型的自动装配将无法工作, 此时可以在加入@Qualifier注解里提供Bean的名称.
  Spring允许对方法的入参标注@Qualifier用来指定注入Bean的名称.
  * @Autowired 注解可以应用到数组类型的属性上, 此时spring将会把所有匹配的Bean进行自动装配(spring4.x 之后可以使用@Order注解为匹配的Bean进行排序操作)
  * @Autowired 注解可以应用到集合类型的属性上, 此时spring将会把所有匹配的Bean进行自动装配
  * @Autowired 注解可以应用到java.util.Map上, 若该Map的键类型为String, 那么spring将自动装配与之Map值类型兼容的Bean, 此时Bean的名称作为键值.
  

