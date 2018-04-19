package spring4.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.beans.PropertyVetoException;

/**
 * @author zail
 * @since 2017-12-21
 */
@Configuration
@PropertySource("db.properties")
public class SetDataSource {
  
  @Autowired
  private Environment environment;

  @Bean
  public ComboPooledDataSource configDataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setUser(environment.getProperty("jdbc.user"));
    dataSource.setPassword(environment.getProperty("jdbc.password"));
    dataSource.setDriverClass(environment.getProperty("jdbc.driverClass"));
    dataSource.setJdbcUrl(environment.getProperty("jdbc.jdbcUrl"));
    
    dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("jdbc.initialPoolSize")));
    dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("jdbc.maxPoolSize")));
    return dataSource;
  }
  
}
