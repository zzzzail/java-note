package com.fsocity.learn.java.collection;

import com.fsocity.learn.java.entity.Course;
import com.fsocity.learn.java.entity.Student;

import java.util.HashSet;
import java.util.Set;

/**
 *   Collection            Map
 * List Queue Set      HashMap(哈希表)
 *
 * List 存储的就是一系列对象
 * List(序列) 和 Queue(队列) 都是排列有序的, 并且可以重复的
 * Set(集) 是无序的, 并且不可以重复的
 *
 * ArrayList 继承 List
 * LinkedList 继承 List 和 Queue
 * HashSet 继承 Set
 *
 * Map 存储的是键值对
 *
 * @author zail
 * @since 2018-01-27
 */
public class CollectionTest {
  
  public static void main(String[] args) {
    Course course1 = new Course(1, "java");
    Course course2 = new Course(2, "node.js");
    
    Set<Course> courses = new HashSet<Course>();
    courses.add(course1);
    courses.add(course2);
    
    Student student = new Student();
    student.setId(1);
    student.setName("张二狗");
    student.setCourses(courses);
    System.out.println(student);
  }
}
