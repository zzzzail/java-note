package com.fsocity.learn.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程类
 *
 * @author zail
 * @since 2018-01-27
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {
  
  // 课程id
  private int id;
  
  // 课程名称
  private String name;
  
  /**
   * 重写 equals 方法
   * @param obj
   * @return
   */
  @Override
  public boolean equals(Object obj) {
    // 1. 判断是否是同一个对象(同一个堆对象中的引用), 如果是直接返回 true, 提高性能
    if (this == obj)
      return true;
  
    /**
     * 判断 obj 是否为null, 如果是null, 一定不是equals的,
     * 因为既然当前对象this能调用equals方法, 那么它一定不是null, 非 null 和 null 做比较一定不等价.
     * 判断两个对象运行时的类是否相同, 不是相同的类则不 equals,
     * getClass() 返回的是this和obj的运行时类的引用. 如果它们属于用一个类, 则返回的是同一个运行时类的引用.
     * (一个类也是一个对象)
     */
    if ((obj == null) || (obj.getClass() != this.getClass()))
      return false;
    
    Course course = (Course) obj;
    return this.id == course.getId() && this.name.equals(course.getName());
  }
}
