package spring4.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author zail
 * @since 2017-12-21
 */
@Component
public class SetJDBCTemplate {
  
  @Autowired
  @Qualifier("configDataSource")
  private ComboPooledDataSource dataSource;
  
  @Bean
  public JdbcTemplate configJdbcTemplate() {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    jdbcTemplate.setDataSource(dataSource);
    return jdbcTemplate;
  }
}
