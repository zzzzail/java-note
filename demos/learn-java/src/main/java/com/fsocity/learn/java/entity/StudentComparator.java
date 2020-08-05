package com.fsocity.learn.java.entity;

import java.util.Comparator;

/**
 * @author zail
 * @since 2018-01-29
 */
public class StudentComparator implements Comparator<Student> {
  
  public int compare(Student o1, Student o2) {
    return o1.getName().compareTo(o2.getName());
  }
}
