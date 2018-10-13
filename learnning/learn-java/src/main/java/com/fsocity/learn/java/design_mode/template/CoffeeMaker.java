package com.fsocity.learn.java.design_mode.template;

/**
 * 提供了咖啡制作的具体实现类
 *
 * @author zail
 * @since 2018-09-28
 */
public class CoffeeMaker extends MakeRefreshBeverageTemplate {
  
  @Override
  protected void brew() {
    System.out.println("用沸水冲泡咖啡");
  }
  
  @Override
  protected void addCondiments() {
    System.out.println("为咖啡加入糖和牛奶");
  }
  
}
