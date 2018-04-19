package com.fsocity.learn.java.reflect;

/**
 * @author zail
 * @since 2018-01-29
 */
public class Office {
  
  public static void main(String[] args)
    throws ClassNotFoundException, IllegalAccessException, InstantiationException {
  
    /**
     * new 创建对象都是静态加载类, 在编译时刻就需要加载所有的可能使用到的类.
     * 通过动态加载可以解决该问题
     */
    // if ("World".equals(args[0])) {
    //   World world = new World();
    //   world.start();
    // }
    //
    // if ("Excel".equals(args[0])) {
    //   Excel excel = new Excel();
    //   excel.start();
    // }
  
    /**
     * 动态加载类, 在运行时刻
     */
    Class clazz = Class.forName(args[0]);
    OfficeAble officeAble = (OfficeAble) clazz.newInstance();
    officeAble.start();
  }
}
