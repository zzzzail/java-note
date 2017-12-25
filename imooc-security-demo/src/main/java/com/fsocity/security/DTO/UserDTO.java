package com.fsocity.security.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

/**
 * @author zail
 * @since 2017-12-25
 */
@Data
public class UserDTO {
  
  public interface UserDTOSimpleView {}
  public interface UserDTODetailView extends UserDTOSimpleView {}
  
  @JsonView(UserDTOSimpleView.class)
  private String username;
  
  @JsonView(UserDTODetailView.class)
  private String password;
  
  public UserDTO() {
  }
  
  public UserDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
