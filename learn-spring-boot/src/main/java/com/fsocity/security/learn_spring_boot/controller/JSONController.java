package com.fsocity.security.learn_spring_boot.controller;

import com.fsocity.security.learn_spring_boot.pojo.User;
import com.fsocity.security.learn_spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/json")
public class JSONController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user",
            // 精确匹配
            // consumes = {
            //   MediaType.TEXT_HTML_VALUE,
            //   MediaType.APPLICATION_XHTML_XML_VALUE,
            //   MediaType.APPLICATION_JSON_VALUE
            // },
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User user() {
        User user = userService.getCurrentUser();

        // 描述该前端控制器中的接口方法
        user.add(linkTo(methodOn(JSONController.class).setUserName("username")).withSelfRel());
        user.add(linkTo(methodOn(JSONController.class).setUserAge(20)).withSelfRel());
        return user;
    }

    @GetMapping(value = "/user/set/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserName(@RequestParam String name) {
        return userService.setCurrentUserName(name);
    }

    @GetMapping(value = "/user/set/age", produces = MediaType.APPLICATION_JSON_VALUE)
    public User setUserAge(@RequestParam int age) {
        return userService.setCurrentUserAge(age);
    }

}
