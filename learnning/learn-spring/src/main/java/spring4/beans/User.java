package spring4.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "user")
public class User {

  private Integer id;
  private String name;
  private Integer age;

  public User() {
  }

  public User(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public Integer getId() {
    return id;
  }

  @Value("1")
  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  @Value("zail")
  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  @Value("20")
  public void setAge(Integer age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "User{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
