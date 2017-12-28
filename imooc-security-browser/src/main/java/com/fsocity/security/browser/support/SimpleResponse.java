package com.fsocity.security.browser.support;

import lombok.Data;

/**
 * @author zail
 * @since 2017-12-27
 */
@Data
public class SimpleResponse {

  private Object content;
  
  public SimpleResponse() {
  }
  
  public SimpleResponse(Object content) {
    this.content = content;
  }
}
