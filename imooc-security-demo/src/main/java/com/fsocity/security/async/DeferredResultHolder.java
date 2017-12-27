package com.fsocity.security.async;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zail
 * @since 2017-12-26
 */
@Component
public class DeferredResultHolder {

  private Map<String, DeferredResult<String>> map = new HashMap<>();
  
  public Map<String, DeferredResult<String>> getMap() {
    return map;
  }
  
  public void setMap(Map<String, DeferredResult<String>> map) {
    this.map = map;
  }
}
