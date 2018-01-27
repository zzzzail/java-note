package com.fsocity.learn.java.collection;

import com.fsocity.learn.java.entity.Course;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * HashSet 的不可重复性是使用 HashMap 的key值不可重复性实现的,
 * 我们在给 HashSet#add 方法添加对象时,
 * HashSet 会为一个内部的变量 HashMap<E,Object> map (key为添加的对象, value 为空 Object)添加值,
 * 如果添加成功返回 true
 * 如果添加失败(HashMap 中的key值存在则失败)返回 false.
 * @author zail
 * @since 2018-01-27
 */
public class SetTest {

  private Set<Course> courseSet = new HashSet<Course>();
  
  /**
   * 测试添加属性
   */
  public void testAdd() {
    Course c1 = new Course(1, "java基础");
    courseSet.add(c1);
    // 添加不成功, 因为Set是无序集并且不可重复.
    // courseSet.add(c1);
    
    Course c2 = new Course(2, "离散数学");
    courseSet.add(c2);
    
    Course c3 = new Course(3, "汇编语言");
    courseSet.add(c3);
  }
  
  /**
   * 测试遍历
   */
  public void testForeach() {
    for (Course c:courseSet) {
      System.out.println(c);
    }
  }
  
  /**
   * 测试迭代器遍历集
   */
  public void testIterator() {
    Iterator<Course> iterator = courseSet.iterator();
    while (iterator.hasNext()) {
      Course c = iterator.next();
      System.out.println(c);
    }
  }
  
  public static void main(String[] args) {
    SetTest setTest = new SetTest();
    setTest.testAdd();
    setTest.testForeach();
    
    setTest.testIterator();
  }
}
