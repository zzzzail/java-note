package TheArtOfJavaConcurrencyProgramming.Section05;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.util.concurrent.TimeUnit;

/**
 * @author zail
 * @since 2018-09-12
 */
public class ConnectionDriver {
  
  static class ConnectionHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      if (method.getName().equals("commit")) {
        TimeUnit.MILLISECONDS.sleep(100);
      }
      return null;
    }
  }
  
  // 创建一个 Connection 的代理, 在 commit 时休眠100毫秒
  public static Connection createConnection() {
    return (Connection) Proxy.newProxyInstance(ConnectionDriver.class.getClassLoader(),
      new Class[]{Connection.class},
      new ConnectionHandler());
  }
  
}
