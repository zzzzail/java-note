package com.fsocity.learn.java.design_mode.template;

/**
 * @author zail
 * @since 2018-09-28
 */
public class TeaMaker extends MakeRefreshBeverageTemplate {
  
  @Override
  protected void brew() {
    System.out.println("用80度的热水浸泡茶叶5分钟");
  }
  
  @Override
  protected void addCondiments() {
    System.out.println("加入柠檬");
  }
  
}
