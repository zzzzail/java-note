package com.fsocity.learn.java.design_mode.template;

/**
 * 模版方法设计模式
 *
 * 1. 什么是模版方法模式?
 * 2. 如何实现模版方法模式?
 * 3. 模版方法模式的优缺点?
 * 4. 模版方法模式在实际应用中的作用?
 *
 * @author zail
 * @since 2018-09-28
 */
public class TemplateTest {
  
  // test
  public static void main(String[] args) {
    
    // 制作咖啡
    System.out.println("咖啡制作中...");
    CoffeeMaker coffeeMaker = new CoffeeMaker();
    coffeeMaker.prepareTemplate();
    System.out.println("咖啡制作完成");
  
    System.out.println("------");
    
    System.out.println("茶制作中...");
    TeaMaker teaMaker = new TeaMaker();
    teaMaker.prepareTemplate();
    System.out.println("茶制作完成");
    
  }
  
}
