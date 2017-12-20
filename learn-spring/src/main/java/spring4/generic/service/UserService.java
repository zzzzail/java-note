package spring4.generic.service;

import org.springframework.stereotype.Service;
import spring4.generic.entity.User;

/**
 * @author zail
 * @since 2017-12-20
 */
@Service
public class UserService extends BaseService<User> {
  
  public void save() {
    System.out.println("userService#save");
    System.out.println(repository);
  }
  
}
