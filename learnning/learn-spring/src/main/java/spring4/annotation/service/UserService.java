package spring4.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import spring4.annotation.repository.UserRepository;

/**
 * @author zail
 * @since 2017-12-19
 */
@Service
public class UserService {
  
  @Autowired
  @Qualifier("userRepositoryImpl")
  private UserRepository userRepository;
  
  public void save() {
    System.out.println("UserService#save");
    System.out.println(this);
    userRepository.save();
  }
  
}
