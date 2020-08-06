package org.teiba.java.dsa.basic;

/**
 * 斐波那契数列
 * <p>
 * 斐波那契数列指的是这样一个数列：
 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233，377，
 * 610，987，1597，2584，4181，6765，10946，17711，28657，46368........
 * 这个数列从第3项开始，每一项都等于前两项之和。
 * <p>
 * 斐波那契数列又称黄金分割数列、因数学家列昂纳多·斐波那契（Leonardoda Fibonacci）
 * 以兔子繁殖为例子而引入，故又称为“兔子数列”。在数学上，斐波纳契数列以如下被以递归的方
 * 法定义：F(0)=0，F(1)=1, F(n)=F(n-1)+F(n-2)（n>=2，n∈N*）。
 *
 * @author zail
 * @date 2020/7/19
 */
public class FibonacciSequenceDemo {
    
    public static void main(String[] args) {
    /*
    // 定义第一个加数a，初始值为1；定义第二个加数b，初始值为1；定义两个加数之和为c，初始值为0
    int a = 1;
    int b = 1;
    int c = 0;
    
    // 首先在控制台打印出数列中第一个数和第二个数的值
    System.out.print(a + "\n" + b + "\n");
    
    // 建立一个for循环，用于循环输出数列中第三位至第十位的数字
    for (int i = 3; i < 10; i++) {
      // 第三个数字即为c，a+b等于c的值
      c = a + b;
      // 将第一个加数a赋值为数列中的第二个数b的值
      a = b;
      // 将第二个加数b赋值为数列中的第三个数c的值
      b = c;
      // 循环打印
      System.out.println(c);
    }
    */
        
        // 第二种方法
        int a = 1;
        int b = 1;
        for (int i = 0; i < 20; i++) {
            // 循环打印a，b两个数字，
            System.out.print(a + "\n" + b + "\n");
            // 加
            a = a + b;
            b = a + b;
        }
    }
    
}
