package spring4.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * @author zail
 * @since 2017-12-21
 */
@Repository
public class TestObjectDao {
  
  @Autowired
  private JdbcTemplate jdbcTemplate;
  
  public TestObject findById(Integer id) {
    String sql = "SELECT id,name,age FROM test WHERE id=?";
    Object[] args = new Object[]{id};
    RowMapper<TestObject> rowMapper = new BeanPropertyRowMapper<TestObject>(TestObject.class);
    TestObject result = jdbcTemplate.queryForObject(sql, args, rowMapper);
    return result;
  }
  
}
