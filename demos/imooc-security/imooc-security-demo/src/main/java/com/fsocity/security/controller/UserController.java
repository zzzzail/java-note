package com.fsocity.security.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fsocity.security.DTO.UserDTO;
import com.fsocity.security.condition.UserQueryCondition;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2017-12-25
 */
@RestController
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private ProviderSignInUtils providerSignInUtils;
  
  @GetMapping("/regist")
  public void regist(UserDTO userDTO, HttpServletRequest request) {
    // 不管是注册用户还是绑定用户, 都会拿到一个用户的唯一标识
    String userId = userDTO.getId();
    providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
  }
  
  @GetMapping("/me")
  public Object me() {
    return SecurityContextHolder.getContext().getAuthentication();
  }
  
  // @RequestMapping(value = "/user", method = RequestMethod.GET)
  // @GetMapping("/user")
  @GetMapping
  @JsonView(UserDTO.UserDTOSimpleView.class)
  @ApiOperation(value = "查询所有用户")
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
  
  // @GetMapping("/user/{id:\\d+}")
  @GetMapping("/{id:\\d+}")
  @JsonView(UserDTO.UserDTODetailView.class)
  public UserDTO queryUser(@PathVariable String id) {
    
    System.out.println("进入 queryUser 服务.");
    
    UserDTO user = new UserDTO();
    user.setUsername("zail");
    user.setPassword("pass");
    
    return user;
  }
  
  @PostMapping
  @JsonView(UserDTO.UserDTOSimpleView.class)
  public UserDTO createUser(@RequestBody @Valid UserDTO userDTO,
                            BindingResult errors) {
    
    if (errors.hasErrors()) {
      errors.getAllErrors().stream().forEach(e -> System.out.println(e));
    }
    
    System.out.println(userDTO);
    
    userDTO.setId("1");
    return userDTO;
  }
  
  @PutMapping("/{id:\\d+}")
  @JsonView(UserDTO.UserDTOSimpleView.class)
  public UserDTO updateUser(@Valid @RequestBody UserDTO userDTO,
                            BindingResult errors) {
    
    if (errors.hasErrors()) {
      errors.getAllErrors().stream().forEach(
        e -> {
          // FieldError fieldError = (FieldError)e;
          // String message = fieldError.getField() + ": " + fieldError.getDefaultMessage();
          // System.out.println(message);
          System.out.println(e.getDefaultMessage());
        }
      );
    }
    
    System.out.println(userDTO);
    
    userDTO.setId("1");
    return userDTO;
  }
  
  @DeleteMapping("/{id:\\d+}")
  public void deleteUser(@PathVariable String id) {
    System.out.println(id);
  }
  
}
