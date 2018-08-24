package com.fsocity.learn.java.thread;

/**
 * @author zail
 * @since 2018-07-08
 */
public class ThreadJoinDemo extends Thread {
  
  // 银行账户
  private BankAccount bankAccount;
  
  private Double money;
  
  public ThreadJoinDemo(String name, BankAccount bankAccount, Double money) {
    super(name);
    
    this.bankAccount = bankAccount;
    this.money = money;
  }
  
  // 线程任务
  @Override
  public void run() {
    synchronized (this.bankAccount) {
      // 获取当前账户余额
      Double d = this.bankAccount.getBalance();
      // 操作小于 0 则是取钱, 操作大于 0 则是存钱
      if (money < 0 && d < -money) {
        System.out.println(this.getName() + "操作失败, 余额不足!");
        return;
      }
      else {
        // 对账户进行操作
        d += money;
        System.out.println(this.getName() + "操作成功, 目前账户余额为: " + d);
        
        try {
          Thread.sleep(1);
        }
        catch (InterruptedException e) {
          e.printStackTrace();
        }
        
        // 修改账户余额
        this.bankAccount.setBalance(d);
      }
    }
  }
  
  public static void main(String[] args) {
    // 创建一个银行账户
    BankAccount account = new BankAccount("600001", 5000.0);
    
    // 创建多个线程, 对账户进行存取钱操作
    ThreadJoinDemo t1 = new ThreadJoinDemo("T001", account, -3000.0);
    ThreadJoinDemo t2 = new ThreadJoinDemo("T001", account, -3000.0);
    ThreadJoinDemo t3 = new ThreadJoinDemo("T001", account, 1000.0);
    ThreadJoinDemo t4 = new ThreadJoinDemo("T001", account, -2000.0);
    ThreadJoinDemo t5 = new ThreadJoinDemo("T001", account, 2000.0);
    
    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    
    // 等待所有线程完成
    try {
      t1.join();
      t2.join();
      t3.join();
      t4.join();
      t5.join();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }
    
    System.out.println("账号: " + account.getAccountNo() + ", 余额: " + account.getBalance());
  }
}
