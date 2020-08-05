package reflect;

/**
 * @author zail
 * @since 2018-05-29
 */
public class ClassDemo01 {
    
    public static void main(String[] args) {
        
        Foo foo = new Foo();
        // Foo 类本身也是一个实例对象, Class 类的实例对象, 如何表示呢?
        // 任何一个类都是 Class 类的实例对象
        
        // 第一种表示方式
        Class c1 = Foo.class;
        
        // 第二种表示方式
        Class c2 = foo.getClass();
        
        /**
         * 官网c1, c2 表示了 Foo 类的类类型 (class type)
         * 万事万物皆对象
         * 类也是对象, 是 Class 类的实例对象
         * 这个对象我们称为该类的类类型
         */
        
        // 不管 c1 或者 c2 都代表了 Foo 类的类类型
        // 一个类只可能是Class 类的一个实例对象
        System.out.println(c1 == c2);
        
        // 第三种表示方式 动态加载类
        Class c3 = null;
        try {
            c3 = Class.forName("reflect.Foo");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(c2 == c3);
        
        // 我们完全可以通过类的类类型来创建该类的对象
        // 通过 c1 或 c2 或 c3 来创建 Foo 的实例
        Foo foo1 = null;
        try {
            foo1 = (Foo) c1.newInstance(); // 必需要有无参构造
        }
        catch (InstantiationException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        foo1.print();
    }
}

class Foo {
    
    public void print() {
        System.out.println("print");
    }
}
