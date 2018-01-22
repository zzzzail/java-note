package com.fsocity.security.core.properties;

import lombok.Data;
import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author zail
 * @since 2018-01-19
 */
@Data
public class QQProperties extends SocialProperties {

  private String providerId = "QQ";

}
