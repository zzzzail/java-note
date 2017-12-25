package com.fsocity.security.learn_spring_boot.pojo;

import org.springframework.hateoas.ResourceSupport;

public class User extends ResourceSupport {

  private String name;
  private int age;

  public User() {
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
      "name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
