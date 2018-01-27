package spring4.factory;

/**
 * 简单工厂
 * 分析:
 *   从代码中可以发现, 简单工厂拥有一定判断能力, 构建结果取决于入参, 使用起来也十分的方便,
 *   也正因为使用太过方便而导致高耦合的情况, 所有对象实例化都需要依赖它, 一旦出问题, 影响的会是整个系统.
 * 使用场景: 创建简单, 无复杂业务逻辑的对象
 * @author zail
 * @since 2018-01-26
 */
public class SimpleFactory {
  
  private static final String CIRCLE = "CIRCLE";
  
  private static final String SQUARE = "SQUARE";
  
  public static Shape getFactory(String type) {
    if (CIRCLE.equals(type)) {
      return new Circle();
    }
    else if (SQUARE.equals(type)) {
      return new Square();
    }
    else {
      throw new NullPointerException("未描述任何图形");
    }
  }
  
  public static void main(String[] args) {
    Shape circle = getFactory(CIRCLE);
    circle.draw();
    
    Shape square = getFactory(SQUARE);
    square.draw();
  }
}
