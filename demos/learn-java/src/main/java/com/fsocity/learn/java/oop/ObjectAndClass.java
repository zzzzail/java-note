package com.fsocity.learn.java.oop;

/**
 * Object 是类层级结构的根
 * Class 是类的定义
 * @author zail
 * @since 2018-03-02
 */
public class ObjectAndClass {
  
  /**
   * 比较方法
   * @param obj
   * @return
   */
  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
  
  /**
   * 完成
   * @throws Throwable
   */
  @Override
  protected void finalize() throws Throwable {
    super.finalize();
  }
  
  /**
   * 复制
   * @return
   * @throws CloneNotSupportedException
   */
  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  
  /**
   * 转字符串
   * @return
   */
  @Override
  public String toString() {
    return super.toString();
  }
  
  /**
   * 哈希码
   * @return
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }
}
