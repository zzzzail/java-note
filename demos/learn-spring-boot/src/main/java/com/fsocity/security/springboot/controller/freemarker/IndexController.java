package com.fsocity.security.springboot.controller.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zail
 * @since 2018-02-04
 */
@Controller
@RequestMapping("/freemarker")
public class IndexController {

  private String viewPrefix = "";

  @GetMapping("/index")
  public String index(Model model) {
    model.addAttribute("username", "Hello, Freemarker!");

    return "index";
  }
}
