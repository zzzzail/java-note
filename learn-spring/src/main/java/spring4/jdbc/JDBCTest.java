package spring4.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2017-12-21
 */
public class JDBCTest {
  
  private ApplicationContext ctx;
  private JdbcTemplate jdbcTemplate;

  {
    ctx = new AnnotationConfigApplicationContext(SpringApplication.class);
    jdbcTemplate = (JdbcTemplate) ctx.getBean("configJdbcTemplate");
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

}
