package TheArtOfJavaConcurrencyProgramming.Section822;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author zail
 * @since 2018-09-17
 */
public class BankWaterService implements Runnable {
  
  // 创建 4 个屏障, 处理完成后执行当前类的 run 方法
  private CyclicBarrier c = new CyclicBarrier(4, this);
  
  // 假设有4个 sheet, 所以启动4个线程
  private Executor executor = Executors.newFixedThreadPool(4);
  
  // 保存每个 sheet 计算出的银流结果
  private ConcurrentHashMap<String, Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
  
  private void count() {
    for (int i = 0; i < 4; i++) {
      executor.execute(() -> {
        sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
        
        try {
          c.await();
        }
        catch (InterruptedException | BrokenBarrierException e) {
          e.printStackTrace();
        }
      });
    }
  }
  
  @Override
  public void run() {
    int result = 0;
    // 汇总每个 sheet 计算出的结果
    for (Map.Entry<String, Integer> sheet : sheetBankWaterCount.entrySet()) {
      result += sheet.getValue();
    }
    // 将结果输出
    sheetBankWaterCount.put("result", result);
    System.out.println(result);
  }
  
  public static void main(String[] args) {
    BankWaterService bankWaterService = new BankWaterService();
    bankWaterService.count();
    System.out.println("结束");
  }
}
