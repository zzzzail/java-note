package com.fsocity.learn.java.collection;

import com.fsocity.learn.java.entity.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * HashMap 是基于 HasCode 来实现的
 * key 和 value 都可以是 null, 但HasMap中只能有一个key值是null(key的值是不可重复的).
 * @author zail
 * @since 2018-01-27
 */
public class MapTest {
  
  // 学生类型的对象
  private Map<String, Student> students = new HashMap<String, Student>();
  
  /**
   * 添加学生对象, 判断是否被占用
   * 若被占用, 则输入姓名, 创建新学生对象, 并且添加到 students 中
   */
  public void testPut() {
    Scanner console = new Scanner(System.in);
    for (int i = 0; i < 3; i++) {
      System.out.println("请输入学生ID: ");
      int id = console.nextInt();
      // 判断 id 是否存在
      Student student = students.get(String.valueOf(id));
      if (student == null) {
        // 提示用户输入姓名
        System.out.println("请输入姓名: ");
        String name = console.next();
        Student s = new Student(id, name);
        
        // 通过调用students的put方法, 添加 id - 学生映射
        students.put(String.valueOf(id), s);
      }
      else {
        System.out.println("该学生id已被占用: " + student);
      }
    }
  }
  
  public void testKeySet() {
    // 返回map中的键的集合
    Set<String> keys = students.keySet();
    for (String key: keys) {
      System.out.print(key);
      Student s = students.get(key);
      if (s != null) {
        System.out.println("学生: " + s.getName());
      }
      else {
        System.out.println();
      }
    }
  }
  
  public static void main(String[] args) {
    MapTest mapTest = new MapTest();
    mapTest.testPut();
    mapTest.testKeySet();
  }
}
