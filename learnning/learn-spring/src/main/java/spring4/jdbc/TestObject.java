package spring4.jdbc;

/**
 * @author zail
 * @since 2017-12-21
 */
public class TestObject {
  
  private Integer id;
  private String name;
  private Integer age;
  
  public TestObject() {
  }
  
  public TestObject(Integer id, String name, Integer age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Integer getAge() {
    return age;
  }
  
  public void setAge(Integer age) {
    this.age = age;
  }
  
  @Override
  public String toString() {
    return "TestObject{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", age=" + age +
      '}';
  }
}
