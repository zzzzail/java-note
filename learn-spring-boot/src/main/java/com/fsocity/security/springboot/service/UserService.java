package com.fsocity.security.springboot.service;

import com.fsocity.security.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Bean
  public User getCurrentUser() {
    User user = new User();
    user.setName("zail");
    user.setAge(19);
    return user;
  }

  @Autowired
  @Qualifier("getCurrentUser")
  private User user;

  public User setCurrentUserName(String name) {
    user.setName(name);
    return user;
  }

  public User setCurrentUserAge(int age) {
    user.setAge(age);
    return user;
  }

}
