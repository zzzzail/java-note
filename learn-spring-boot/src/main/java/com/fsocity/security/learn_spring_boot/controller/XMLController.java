package com.fsocity.security.learn_spring_boot.controller;

import com.fsocity.security.learn_spring_boot.pojo.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xml")
public class XMLController {

  @GetMapping(value = "/user", produces = MediaType.APPLICATION_XML_VALUE)
  public User user() {
    User user = new User();
    user.setName("zail");
    user.setAge(18);
    return user;
  }

}
