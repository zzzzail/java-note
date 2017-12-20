package spring4.AOP.helloworld;

import sun.jvm.hotspot.oops.Array;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author zail
 * @since 2017-12-20
 */
public class ArithmeticCalculatorLoggingProxy {
  
  private ArithmeticCalculator target;
  
  public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target) {
    this.target = target;
  }
  
  public ArithmeticCalculator getLoggingProxy() {
    ArithmeticCalculator proxy = null;
    
    // 代理对象由哪一个类加载器负责加载
    ClassLoader loader = target.getClass().getClassLoader();
    // 代理对象的类型, 即其中有哪些方法
    Class[] interfaces = new Class[]{ArithmeticCalculator.class};
    // 当调用代理对象其中的方法时, 该执行的代码
    InvocationHandler h = new InvocationHandler() {
      /**
       *
       * @param proxy   正在返回的的那个代理对象, 一般情况下, 在invoke方法中都不适用该对象.
       * @param method  正在被调用的方法
       * @param args    调用方法时, 传入的参数
       * @return
       * @throws Throwable
       */
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        // 日志
        System.out.println("[INFO] -->> The method add begins with " + Arrays.asList(args));
        
        // 执行方法
        Object result = null;
        try {
          // @Before
          result = method.invoke(target, args);
          // @After
        }
        catch (Exception e) {
          e.printStackTrace();
          // @AfterThrowing
        }
        
        System.out.println("[INFO] -->> The method add begins with " + result);
        return result;
      }
    };
    
    proxy = (ArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
    return proxy;
  }
  
}
