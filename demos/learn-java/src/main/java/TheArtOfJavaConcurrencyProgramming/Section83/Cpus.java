package TheArtOfJavaConcurrencyProgramming.Section83;

/**
 * @author zail
 * @since 2018-09-17
 */
public class Cpus {
  
  public static void main(String[] args) {
    // 当前设备的 cpu 核心数
    int cpus = Runtime.getRuntime().availableProcessors();
    System.out.println(cpus);
  }
}
