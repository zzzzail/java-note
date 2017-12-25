package com.fsocity.security.retail.utils;

import com.fsocity.retail.vo.HTTPResponseVo;

import java.util.List;

/**
 * @author zail
 * @version imp01.0.0
 */
public class HTTPResponseVoUtil {

  /** HTTP 请求返回状态 */
  public static HTTPResponseVo success(Object object) {
    HTTPResponseVo httpResponseVo = new HTTPResponseVo();
    httpResponseVo.setCode(0);
    httpResponseVo.setMessage("success!");
    httpResponseVo.setData(object);
    return httpResponseVo;
  }

  public static HTTPResponseVo success() {
    return success(null);
  }

  public static HTTPResponseVo error(Integer code, String message) {
    HTTPResponseVo httpResponseVo = new HTTPResponseVo();
    httpResponseVo.setCode(code);
    httpResponseVo.setMessage(message);
    return httpResponseVo;
  }

}
