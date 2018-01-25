package spring4.singleton;

/**
 * 一个国家有且仅有一个president, president只能被实例化一次, getPresident() 返回这个仅有的 president
 * @author zail
 * @since 2018-01-22
 */
public class AmericaPresident {

  private static final AmericaPresident thePresident = new AmericaPresident();
  
  private AmericaPresident() {}
  
  public static AmericaPresident getPresident() {
    return thePresident;
  }
}
