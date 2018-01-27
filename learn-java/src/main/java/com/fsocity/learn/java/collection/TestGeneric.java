package com.fsocity.learn.java.collection;

import com.fsocity.learn.java.entity.ChildCourse;
import com.fsocity.learn.java.entity.Course;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2018-01-27
 */
public class TestGeneric {
  
  /**
   * 泛型
   * 泛型集合中, 不能添加泛型规定的类型及子类型以外的对象, 否则会报错
   * 泛型不能是基本类型的, 必须是引用类型的  List<int>
   */
  private List<Course> courses;
  
  // Type argument cannot be of primitive type.
  // 规定的泛型不能使用基本类型
  // private List<int> lists;
  private List<Integer> integers;
  
  public TestGeneric() {
    this.courses = new ArrayList<Course>();
  }
  
  /**
   * 测试增加
   */
  public void testAdd() {
    Course course1 = new Course(1, "大学语文");
    courses.add(course1);
    
    Course course2 = new Course(1, "大学语文");
    courses.add(course2);
  }
  
  /**
   * 测试遍历数组
   */
  public void testForeach() {
    for (Course c : courses) {
      System.out.println(c);
    }
  }
  
  /**
   * 泛型集合可以添加规定的泛型类的子类型的实例
   */
  public void testAddChild() {
    ChildCourse childCourse = new ChildCourse(1, "子类型的课程对象实例...");
    courses.add(childCourse);
  }
  
  /**
   * 测试泛型使用基本类型的包装类
   */
  public void testPrimitiveType() {
    List<Integer> integers = new ArrayList<Integer>();
    integers.add(9);
    integers.add(10);
    for (Integer i : integers) {
      System.out.println(i);
    }
  }
  
  public static void main(String[] args) {
    TestGeneric generic = new TestGeneric();
    generic.testAdd();
    generic.testForeach();
    
    generic.testAddChild();
    generic.testForeach();
    
    generic.testPrimitiveType();
  }
}
