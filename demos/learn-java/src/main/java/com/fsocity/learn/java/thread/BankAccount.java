package com.fsocity.learn.java.thread;

/**
 * @author zail
 * @since 2018-07-08
 */
public class BankAccount {
  
  private String accountNo;
  
  private Double balance;
  
  public BankAccount(String accountNo, Double balance) {
    this.accountNo = accountNo;
    this.balance = balance;
  }
  
  public String getAccountNo() {
    return accountNo;
  }
  
  public void setAccountNo(String accountNo) {
    this.accountNo = accountNo;
  }
  
  public Double getBalance() {
    return balance;
  }
  
  public void setBalance(Double balance) {
    this.balance = balance;
  }
}
