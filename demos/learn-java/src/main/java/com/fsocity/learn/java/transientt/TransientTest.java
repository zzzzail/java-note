package com.fsocity.learn.java.transientt;

import java.io.*;

/**
 * @author zail
 * @since 2018-05-24
 */
public class TransientTest {
    
    /**
     * transient 瞬时的、瞬变的、短暂的
     * meaning: working or staying somewhere for only a short time
     * Java 中的关键字 transient 表示,
     * 在持久化 Serialization 中的特殊的对象数据成员我们不想用 Serialization 的机制来保存它的时候,
     * 使用该关键字声明该字段是瞬时的.
     * <p>
     * 首先先说明 Serialization 的作用吧,
     * Serialization 是 Java 提供的一种机制叫做序列化, 有了这种机制我们就可以通过把某个对象序列化后
     * 再次通过反序列化转换为我们创建的那个对象, 这样一来一回呢就实现了持久化的操作. 也就是说我们可以
     * 先把某个对象序列化后保存成为一个文件, 再通过反序列化文件得到持久化的对象, 这样来实现持久化操作.
     * 而不是对象一直保持在程序执行的内存中创建销毁等.
     * <p>
     * 为什么会有 transient 这个关键字呢?
     * 就是因为当一个你想要用 Serialization 机制来持久化一个对象时, 该对象中有你不想持久化的成员对象.
     * 我们可以通过 transient 关键字来声明该成员不会被包含在序列化的范围内, 只保存在内存中.
     *
     * 输出:
     * Read before Serialization ...
     * username = zail
     * password = 123456
     * Read after Serialization ...
     * username = zail
     * password = null
     * 说明反序列化时没有从文件中获取到 password 成员对象
     *
     *
     * 小结:
     * 1. 一旦成员被 transient 修饰, 该成员则不再是对象持久化中的一部分, 该成员变量数据在序列化后无法获得.
     * 2. transient 关键字只能修饰成员变量, 不能修饰方法和类.
     * 注意: 本地成员变量是不能被 transient 关键字修饰的. 成员变量如果是用户自定义类变量, 则该类需要实现Serializable接口.
     * 3. 被 transient 关键字修饰的成员变量不再能被序列化,
     * 一个静态变量不管是否被 transient 修饰, 均不能被序列化.
     *
     * @param args
     */
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("zail");
        user.setPassword("123456");
        
        System.out.println("Read before Serialization ...");
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream("/Users/zail/user.txt"));
            os.writeObject(user);
            os.flush();
            os.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        try {
            ObjectInputStream is = new ObjectInputStream(
                new FileInputStream("/Users/zail/user.txt"));
            user = (User) is.readObject();
            is.close();
            
            System.out.println("Read after Serialization ...");
            System.out.println("username = " + user.getUsername());
            System.out.println("password = " + user.getPassword());
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    
    private static final long serialVersionUID = -639978949102211248L;
    
    private static String username;
    
    /**
     * 使用 transient 声明时, 不会序列化该成员
     */
    private transient String password;
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
}
