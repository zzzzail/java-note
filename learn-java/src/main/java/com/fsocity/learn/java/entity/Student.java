package com.fsocity.learn.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * 学生类
 * @author zail
 * @since 2018-01-27
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {
  
  // 学生id
  private int id;
  
  // 学生名
  private String name;
  
  // 课程
  private Set courses;
  
  public Student(int id, String name) {
    this.id = id;
    this.name = name;
  }
}
