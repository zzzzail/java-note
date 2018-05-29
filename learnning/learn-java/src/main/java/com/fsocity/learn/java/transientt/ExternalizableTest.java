package com.fsocity.learn.java.transientt;

import java.io.*;

/**
 * @author zail
 * @since 2018-05-25
 */
public class ExternalizableTest implements Externalizable {
    
    private transient String content = "是的, 我将会被序列化, 不管我是否被 transient 修饰.";
    
    public void writeExternal(ObjectOutput out) throws IOException {
    
    }
    
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    
    }
    
    /**
     * 在Java中, 对象的序列化可以通过实现两种接口来实现.
     * 若实现的是 Serializable 接口, 则所有的序列化将会自动进行.
     * 若实现的是 Externalizable 接口, 则没有任何东西可以自动序列化.
     * 需要在 writeExternal 方法中进行手工指定所要序列化的变量.
     * 这与是否被transient修饰无关. 因此第二个例子输出的是变量 content 初始化的内容, 而不是null.
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExternalizableTest et = new ExternalizableTest();
        ObjectOutput out = new ObjectOutputStream(
            new FileOutputStream(new File("test")));
        out.writeObject(et);
    
        ObjectInput in = new ObjectInputStream(
            new FileInputStream(new File("test")));
        et = (ExternalizableTest) in.readObject();
        System.out.println(et.content);
    
        out.close();
        in.close();
    }
}
