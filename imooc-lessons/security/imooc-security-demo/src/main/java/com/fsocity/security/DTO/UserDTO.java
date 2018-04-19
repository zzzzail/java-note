package com.fsocity.security.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.fsocity.security.validator.MyConstraint;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author zail
 * @since 2017-12-25
 */
@Data
public class UserDTO {
  
  public interface UserDTOSimpleView {}
  public interface UserDTODetailView extends UserDTOSimpleView {}
  
  @JsonView(UserDTOSimpleView.class)
  private String id;
  
  @JsonView(UserDTOSimpleView.class)
  @MyConstraint(message = "这是个测试")
  private String username;
  
  @JsonView(UserDTODetailView.class)
  @NotBlank(message = "密码不能为空.")
  private String password;
  
  @JsonView(UserDTOSimpleView.class)
  @Past(message = "生日必须是过去的时间.")
  private Date birthday;
  
  public UserDTO() {
  }
  
  public UserDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
