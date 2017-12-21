package spring4.jdbc;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zail
 * @since 2017-12-21
 */
public class JDBCTest {
  
  private ApplicationContext ctx;
  private JdbcTemplate jdbcTemplate;
  private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
  
  {
    ctx = new AnnotationConfigApplicationContext(SpringApplication.class);
    jdbcTemplate = (JdbcTemplate) ctx.getBean("configJdbcTemplate");
    namedParameterJdbcTemplate = (NamedParameterJdbcTemplate) ctx.getBean("setNamedParameterJdbcTemplate");
  }
  
  /**
   * 可以为参数起名字.
   * 好处是多个参数, 不用对应位置, 直接对应参数名, 方便维护.
   */
  @Test
  public void testNamedParameterJdbcTemplate() {
    String sql = "INSERT INTO test (name, age) VALUES (:name, :age)";
    Map<String, Object> paramMap = new HashMap<String, Object>();
    paramMap.put("name", "DD");
    paramMap.put("age", 22);
    
    namedParameterJdbcTemplate.update(sql, paramMap);
  }
  
  /**
   * 执行 INSERT、UPDATE、DELETE
   */
  @Test
  public void testUpdate() {
    String sql = "UPDATE test SET name=? WHERE id = ?";
    Object[] args = new Object[]{"test222", 3};
    jdbcTemplate.update(sql, args);
  }
  
  /**
   * 批量更新
   */
  @Test
  public void testBatchUpdate() {
    String sql = "INSERT INTO test (name, age) VALUES (?, ?)";
    List<Object[]> batchArgs = new ArrayList<Object[]>();
    batchArgs.add(new Object[]{"AA", 10});
    batchArgs.add(new Object[]{"BB", 20});
    batchArgs.add(new Object[]{"CC", 30});
    
    jdbcTemplate.batchUpdate(sql, batchArgs);
  }
  
  /**
   * 获取相应的对象
   * 1. 其中 RowMapper 指定如何映射结果集的行, 常用的实现类为 BeanPropertyRowMapper
   * 2. 使用 sql 中的别名完成列名和类的属性名的映射
   */
  @Test
  public void testQueryForObject() {
    String sql = "SELECT id,name,age FROM test WHERE id=?";
    Object[] args = new Object[]{1};
    RowMapper<TestObject> rowMapper = new BeanPropertyRowMapper<TestObject>(TestObject.class);
    TestObject object = jdbcTemplate.queryForObject(sql, args, rowMapper);
    System.out.println(object);
  }
  
  /**
   * 获取集合
   */
  @Test
  public void testQueryForList() {
    String sql = "SELECT id,name,age FROM test WHERE id>?";
    Object[] args = new Object[]{2};
    RowMapper<TestObject> rowMapper = new BeanPropertyRowMapper<TestObject>(TestObject.class);
    List<TestObject> result = jdbcTemplate.query(sql, args, rowMapper);
    System.out.println(result);
  }
  
  @Test
  public void testQueryForInteger() {
    String sql = "SELECT count(id) FROM test";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
    System.out.println(count);
  }
}
