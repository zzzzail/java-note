package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zail
 * @since 2018-05-29
 */
public class ClassUtil {
    
    /**
     * 打印类的信息, 包括类的成员函数, 成员变量
     * @param object
     */
    public static void printClassMessage(Object object) {
        // 获取类的信息
        Class clazz = object.getClass();
        // 获取类的名称
        System.out.println("类的名称是: " + clazz.getName());
        System.out.println();
        
        /**
         * Method 类是方法对象, 一个成员方法就是一个 Method 对象.
         * getMethods() 是获取所有的 public 的函数对象, 包括父类继承而来的
         * getDeclaredMethods() 获取的是所有该类自己声明的方法, 不问访问权限
         */
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            // 得到返回值类型的类类型
            System.out.print(method.getReturnType().getName() + " ");
            // 得到方法名
            System.out.print(method.getName() + "(");
            // 获取参数类型, 得到的是参数列表的类型的类类型
            Class[] paramTypes = method.getParameterTypes();
            for (Class c : paramTypes) {
                System.out.print(c.getName() + ", ");
            }
            System.out.print(")");
            System.out.println();
        }
    
        System.out.println();
        /**
         * 成员变量也是对象 java.lang.reflect.Field
         * Field 类封装了关于成员变量的操作
         * getFields() 获取的是所有的 public 的成员变量的信息
         * getDeclaredFields() 获取的是该类自己声明的成员变量的信息
         *
         */
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            Class c = f.getClass();
            String typeName = c.getName();
            String fieldName = c.getName();
            System.out.print(typeName + " " + fieldName);
            System.out.println();
        }
        System.out.println();
    }
}
