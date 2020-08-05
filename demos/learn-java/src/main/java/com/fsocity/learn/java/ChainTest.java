package com.fsocity.learn.java;

/**
 * 使用 initCause 方法实现异常链
 *
 * 实际应用中的经验与总结
 * 1. 处理运行时异常时, 采用逻辑去合理规避同时辅助使用try-catch处理
 * 2. 在多重catch块后面, 可以加上一个catch(Exception)来处理可能会被遗漏的异常
 * 3. 对于不确定的代码, 也可以使用try-catch, 处理潜在的异常
 * 4. 尽量去处理异常, 切忌只是简单的调用printStackTrace()去打印输出
 * 5. 具体如何处理异常, 需要根据不同的业务需求和异常类型去决定
 * 6. 尽量添加finally语句块去释放占用的资源
 * @author zail
 * @since 2018-01-27
 */
public class ChainTest {
  
  public static void main(String[] args) {
    ChainTest chainTest = new ChainTest();
    chainTest.test2();
  }
  
  /**
   * 抛出喝大了异常
   * @see DrunkException
   */
  public void test1() throws DrunkException {
    throw new DrunkException("我喝大了");
  }
  
  /**
   * 捕获喝大了异常
   */
  public void test2() {
    try {
      test1();
    }
    catch (DrunkException e) {
      // e.printStackTrace();
      // RuntimeException runtimeException = new RuntimeException("司机一滴酒, 亲人两行泪...");
      RuntimeException runtimeException = new RuntimeException(e);
      // 设置因为什么引起的异常
      // runtimeException.initCause(e);
      throw runtimeException;
    }
  }
}
