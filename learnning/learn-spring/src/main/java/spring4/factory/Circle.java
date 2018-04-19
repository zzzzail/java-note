package spring4.factory;

/**
 * @author zail
 * @since 2018-01-26
 */
public class Circle implements Shape {
  
  public Circle() {
    System.out.println("创建圆形模型");
  }
  
  @Override
  public void draw() {
    System.out.println("画一个圆形");
  }
}
