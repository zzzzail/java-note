package com.fsocity.learn_spring_boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/jsp")
public class JSPController {

  @GetMapping("/welcome")
  public String welcome(Model model) {
    System.out.println("welcome");
    model.addAttribute("time", new Date());
    model.addAttribute("message", "Hello World!");
    return "welcome";
  }

  @GetMapping("/foo")
  public String foo(Model model) {
    throw new RuntimeException("");
  }

}
