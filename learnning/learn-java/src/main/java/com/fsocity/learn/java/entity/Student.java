package com.fsocity.learn.java.entity;

import lombok.Data;

import java.util.Set;

/**
 * 学生类
 * @author zail
 * @since 2018-01-27
 */
@Data
public class Student implements Comparable<Student> {
  
  // 学生id
  private int id;
  
  // 学生名
  private String name;
  
  // 课程
  private Set courses;
  
  public Student() {}
  
  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }
  
  public int compareTo(Student o) {
    return this.id - o.id;
  }
}
