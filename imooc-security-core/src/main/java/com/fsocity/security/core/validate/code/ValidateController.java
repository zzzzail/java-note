package com.fsocity.security.core.validate.code;

import com.fsocity.security.core.constant.UriConstant;
import com.fsocity.security.core.properties.SecurityProperties;
import com.fsocity.security.core.validate.code.image.ImageCode;
import com.fsocity.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
  @GetMapping(UriConstant.VALIDATE_CODE_URI_PREFIX + "{type}")
  public void createImageCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String type) throws Exception {
    validateCodeProcessors.get(type + "CodeProcessor").create(new ServletWebRequest(request, response));
  }
  
}
