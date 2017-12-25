package com.fsocity.security.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fsocity.security.DTO.UserDTO;
import com.fsocity.security.condition.UserQueryCondition;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2017-12-25
 */
@RestController
public class UserController {
  
  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @JsonView(UserDTO.UserDTOSimpleView.class)
  public List<UserDTO> queryUsers(UserQueryCondition userQueryCondition,
                                 @PageableDefault(page = 2, size = 17, sort = "age, desc") Pageable pageable) {
    
    System.out.println(userQueryCondition);
    System.out.println(pageable);
    
    List<UserDTO> users = new ArrayList<>();
    users.add(new UserDTO("zail1", null));
    users.add(new UserDTO("zail2", "password2"));
    users.add(new UserDTO("zail3", "password3"));
    
    return users;
  }
  
  @GetMapping("/user/{id:\\d+}")
  @JsonView(UserDTO.UserDTODetailView.class)
  public UserDTO queryUser(@PathVariable String id) {
  
    System.out.println(id);
    
    UserDTO user = new UserDTO();
    user.setUsername("zail");
    user.setPassword("pass");
    
    return user;
  }
  
}
