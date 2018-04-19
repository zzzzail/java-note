package spring4.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import spring4.annotation.service.UserService;

/**
 * @author zail
 * @since 2017-12-19
 */
@Controller
public class UserController {
  
  @Autowired
  @Qualifier("userService")
  private UserService userService;
  
  public void execute() {
    System.out.println("UserController#execute");
    System.out.println(this);
    userService.save();
  }
  
}
