package com.fsocity.learn.java.collection;

import com.fsocity.learn.java.entity.Student;
import com.fsocity.learn.java.entity.StudentComparator;

import java.util.*;

/**
 * @author zail
 * @since 2018-01-29
 */
public class CollectionsTest {
  
  /**
   * 1. 通过Collections.sort()方法, 对Integer泛型的List进行排序;
   * 创建一个Integer泛型的List, 插入十个100以内的不重复随机数,
   * 调用Collections.sort()方法对其进行排序.
   */
  public void testSortInteger() {
    List<Integer> integers = new ArrayList<Integer>();
    
    Random random = new Random();
    Integer k = null;
    for (int i = 0; i < 10; i++) {
      do {
        k = random.nextInt(100);
      }
      while (integers.contains(k));
      integers.add(k);
      System.out.println("成功添加整数: " + k);
    }
    System.out.println("------排序前------");
    
    for (Integer i : integers) {
      System.out.print(i + ", ");
    }
    
    System.out.println();
    
    Collections.sort(integers);
    System.out.println("------排序后------");
    for (Integer i : integers) {
      System.out.print(i + ", ");
    }
  }
  
  /**
   * 排序字符串
   */
  public void testSortString() {
    List<String> strings = new ArrayList<String>();
    strings.add("Microsoft");
    strings.add("Google");
    strings.add("Apple");
    
    System.out.println("------排序前------");
    for (String s : strings) {
      System.out.print(s + ", ");
    }
    
    System.out.println();
    
    System.out.println("------排序后------");
    
    /**
     * 排列顺序:
     *   数字: 0 - 9
     *   大写字母: A - Z
     *   小写字母: a - z
     */
    Collections.sort(strings);
    for (String s : strings) {
      System.out.print(s + ", ");
    }
  }
  
  /**
   * 生成一定长度的随机字符串, 并返回.
   *
   * @param length 字符串长度
   * @return
   */
  public String generatorRandomString(int length) {
    String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    
    Random random = new Random();
    StringBuilder result = new StringBuilder();
    
    // 生成
    for (int i = 0; i < length; i++) {
      int l = random.nextInt(chars.length());
      result.append(chars.charAt(l));
    }
    
    return result.toString();
  }
  
  /**
   * 对随机字符串进行排序
   */
  public void testSortRandomString() {
    List<String> strings = new ArrayList<String>();
    
    String str = null;
    for (int i = 0; i < 20; i++) {
      do {
        str = generatorRandomString(5);
      }
      // 如果序列中含有该字符串, 那就再生成一次, 直到序列中没有该字符串为止.
      while (strings.contains(str));
      strings.add(str);
      System.out.println("添加元素: " + str);
    }
  
    System.out.println("------排序前------");
    for (String s : strings) {
      System.out.print(s + ", ");
    }
  
    System.out.println();
    System.out.println("------排序后------");
    Collections.sort(strings);
    for (String s : strings) {
      System.out.print(s + ", ");
    }
  }
  
  public void testSortGeneric() {
    List<Student> students = new ArrayList<Student>();
    students.add(new Student(2, "a小黄"));
    students.add(new Student(3, "c小红"));
    students.add(new Student(1, "b小明"));
  
    System.out.println("------排序前------");
    for (Student s : students) {
      System.out.println(s);
    }
  
    /**
     * 1. 实体类实现 Comparable 接口中的 compareTo方法, 之后才能使用Collections.sort进行排序
     * 2. 可以为Collections.sort传入一个临时的比较对象, 该对象实现Comparator接口中的compare方法.
     */
    Collections.sort(students);
    System.out.println("------排序后------");
    for (Student s : students) {
      System.out.println(s);
    }
  
    Collections.sort(students, new StudentComparator());
    System.out.println("------按照姓名排序后------");
    for (Student s : students) {
      System.out.println(s);
    }
  }
  
  public static void main(String[] args) {
    CollectionsTest test = new CollectionsTest();
    // test.testSortInteger();
    // test.testSortString();
    // test.testSortRandomString();
    test.testSortGeneric();
  }
}

