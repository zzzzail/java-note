package com.fsocity.learn.java.design_mode.template;

/**
 * 制作提神饮料模版类
 * @author zail
 * @since 2018-09-28
 */
public abstract class MakeRefreshBeverageTemplate {
  
  /**
   * 制作饮料的模版方法, 封装了所有子类遵循的算法框架.
   *
   */
  public final void prepareTemplate() {
    
    // 1. 降水煮沸
    boilWater();
    
    // 2. 泡制饮料
    brew();
    
    // 3. 倒入杯中
    poutInCup();
    
    // 4. 加入调味料
    addCondiments();
    
  }
  
  private void boilWater() {
    System.out.println("将水煮沸");
  }
  
  protected abstract void brew();
  
  private void poutInCup() {
    System.out.println("倒入杯中");
  }
  
  protected abstract void addCondiments();
  
}
