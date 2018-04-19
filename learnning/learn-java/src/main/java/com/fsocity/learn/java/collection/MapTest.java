package com.fsocity.learn.java.collection;

import com.fsocity.learn.java.entity.Course;
import com.fsocity.learn.java.entity.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * HashMap 是基于 HasCode 来实现的
 * key 和 value 都可以是 null, 但HasMap中只能有一个key值是null(key的值是不可重复的).
 *
 * @author zail
 * @since 2018-01-27
 */
public class MapTest {
  
  // 学生类型的对象
  private Map<String, Student> students = new HashMap<String, Student>();
  
  public MapTest() {
    students.put("1", new Student(1, "zail"));
    students.put("2", new Student(2, "jack"));
    students.put("3", new Student(3, "tom"));
  }
  
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
    for (String key : keys) {
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
  
  /**
   * 测试删除
   */
  public void testRemove() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.println("请输入要删除的学生id");
      int id = scanner.nextInt();
      
      Student student = students.get(String.valueOf(id));
      if (student != null) {
        System.out.println("输入的id不存在");
        continue;
      }
      
      students.remove(String.valueOf(id));
      break;
    }
  }
  
  /**
   * 获取Map内部类Entry的实例
   */
  public void testEntrySet() {
    Set<Map.Entry<String, Student>> entities = students.entrySet();
    for (Map.Entry<String, Student> entry : entities) {
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }
  }
  
  /**
   * 测试修改
   */
  public void testModify() {
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      System.out.println("请输入要修改的学生id: ");
      int id = scanner.nextInt();
      Student student = students.get(String.valueOf(id));
      if (student == null) {
        System.out.println("学生不存在, 请重试.");
        continue;
      }
      else {
        System.out.println("请输入姓名: ");
        String name = scanner.next();
        student.setName(name);
        break;
      }
    }
  }
  
  /**
   * 测试List是否包含某个元素
   */
  public void testListContains() {
    Course course = new Course();
  }
  
  /**
   * 判断Map中是否包含某个key或某个value
   */
  public void testContainsKeyOrValue() {
    boolean hasKey = students.containsKey("1");
    System.out.println("学生中是否存在该key: " + hasKey);
    
    Student student = new Student(6, "张二狗");
    students.put("6", student);
    boolean hasValue = students.containsValue(student);
    System.out.println("学生中是否存在该value: " + hasValue);
  }
  
  public static void main(String[] args) {
    MapTest mapTest = new MapTest();
    // mapTest.testPut();
    // mapTest.testKeySet();
    // mapTest.testEntrySet();
    // mapTest.testModify();
    // mapTest.testEntrySet();
  
    mapTest.testContainsKeyOrValue();
  }
}
