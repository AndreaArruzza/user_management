package com.savemoney.usermanagement.model.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.savemoney.usermanagement.model.v1.UserDetailResource;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-13T19:41:36.166055+01:00[Europe/Rome]")
public class UserResource   {

  @JsonProperty("id")
  private String id;

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("isValid")
  private Boolean isValid;

  @JsonProperty("userDetail")
  private UserDetailResource userDetail;

  public UserResource id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public UserResource email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  
  @Schema(name = "email", required = false)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserResource password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  
  @Schema(name = "password", required = false)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserResource isValid(Boolean isValid) {
    this.isValid = isValid;
    return this;
  }

  /**
   * Get isValid
   * @return isValid
  */
  
  @Schema(name = "isValid", required = false)
  public Boolean getIsValid() {
    return isValid;
  }

  public void setIsValid(Boolean isValid) {
    this.isValid = isValid;
  }

  public UserResource userDetail(UserDetailResource userDetail) {
    this.userDetail = userDetail;
    return this;
  }

  /**
   * Get userDetail
   * @return userDetail
  */
  @Valid 
  @Schema(name = "userDetail", required = false)
  public UserDetailResource getUserDetail() {
    return userDetail;
  }

  public void setUserDetail(UserDetailResource userDetail) {
    this.userDetail = userDetail;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserResource userResource = (UserResource) o;
    return Objects.equals(this.id, userResource.id) &&
        Objects.equals(this.email, userResource.email) &&
        Objects.equals(this.password, userResource.password) &&
        Objects.equals(this.isValid, userResource.isValid) &&
        Objects.equals(this.userDetail, userResource.userDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, email, password, isValid, userDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResource {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    isValid: ").append(toIndentedString(isValid)).append("\n");
    sb.append("    userDetail: ").append(toIndentedString(userDetail)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

