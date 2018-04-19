package spring4.factory;

/**
 * @author zail
 * @since 2018-01-26
 */
public class Square implements Shape {
  
  public Square() {
    System.out.println("创建方形模型");
  }
  
  @Override
  public void draw() {
    System.out.println("画一个方形");
  }
}
