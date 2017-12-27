package com.fsocity.security.DTO;

import lombok.Data;

/**
 * @author zail
 * @since 2017-12-26
 */
@Data
public class FileInfo {
  
  private String path;
  
  public FileInfo() {
  }
  
  public FileInfo(String path) {
    this.path = path;
  }
}
