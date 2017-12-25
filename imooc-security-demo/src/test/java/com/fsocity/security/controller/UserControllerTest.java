package com.fsocity.security.controller;

import javafx.scene.media.Media;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.awt.*;


/**
 * @author zail
 * @since 2017-12-25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
  
  @Autowired
  private WebApplicationContext wac;
  
  private MockMvc mockMvc;
  
  @Before
  public void setup() {
    mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }
  
  @Test
  public void whenQueryUsersSuccess() throws Exception {
    String result = mockMvc.perform(
      MockMvcRequestBuilders.get("/user")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        // .param("username", "zail")
        .param("username", "zail")
        .param("age", "16")
        .param("ageTo", "20")
        .param("xxx", "yyy")
      
      // Pageable 的参数
      // .param("size", "15")
      // .param("page", "3")
      // .param("sort", "age,desc")
    )
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
      .andReturn().getResponse().getContentAsString();
  
    System.out.println(result);
  }
  
  @Test
  public void whenQueryUserSuccess() throws Exception {
    String result = mockMvc.perform(
      MockMvcRequestBuilders.get("/user/1")
        .contentType(MediaType.APPLICATION_JSON_UTF8)
    )
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andExpect(MockMvcResultMatchers.jsonPath("$.username").isNotEmpty())
      .andReturn().getResponse().getContentAsString();
  
    System.out.println(result);
  }
  
  @Test
  public void whenQueryUserFail() throws Exception {
    mockMvc.perform(
      MockMvcRequestBuilders.get("/user/str")
    )
      .andExpect(MockMvcResultMatchers.status().is4xxClientError());
  }
  
}
