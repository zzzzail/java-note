package com.fsocity.security.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zail
 * @version 0.0.1
 */
@RestController
@RequestMapping("/cache")
@Slf4j
public class CacheController {

  @Autowired
  @Qualifier("simpleCacheManager")
  private CacheManager simpleCacheManager;

  @PostMapping("/save")
  public Map<String, Object> save(@RequestParam String key, @RequestParam String value) {
    System.out.println(key);
    System.out.println(value);
    Cache cache = simpleCacheManager.getCache("cache-1");
    cache.put(key, value);

    Map<String, Object> result = new HashMap<>();
    result.put(key, value);

    return result;
  }

}
