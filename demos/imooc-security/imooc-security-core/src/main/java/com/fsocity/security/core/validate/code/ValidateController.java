package com.fsocity.security.core.validate.code;

import com.fsocity.security.core.properties.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 验证码控制器
 *
 * @author zail
 * @since 2018-01-09
 */
@RestController
public class ValidateController {
  
  @Autowired
  private Map<String, ValidateCodeProcessor> validateCodeProcessors;
  
  /**
   * 根据类型获取验证码
   */
  @GetMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/{type}")
  public void createValidateCode(HttpServletRequest request,
                                 HttpServletResponse response,
                                 @PathVariable String type) throws Exception {
    
    validateCodeProcessors
      .get(type + "CodeProcessor")
      .create(new ServletWebRequest(request, response));
  }
  
}
