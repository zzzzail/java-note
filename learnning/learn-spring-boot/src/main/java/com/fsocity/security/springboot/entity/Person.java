package com.fsocity.security.springboot.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zail
 * @version 0.0.1
 */
@Data
public class Person implements Serializable {

  private String id;

  private String name;

  private Integer age;

}
