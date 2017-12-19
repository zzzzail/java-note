package spring4.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * @author zail
 * @since 2017-12-19
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
  public void save() {
    System.out.println("UserRepository#save");
    System.out.println(this);
  }
}
