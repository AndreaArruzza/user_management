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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-09T09:19:28.207671900+01:00[Europe/Rome]")
public class UserResource   {

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("password")
  private String password;

  @JsonProperty("isValid")
  private Boolean isValid;

  @JsonProperty("userDetail")
  private UserDetailResource userDetail;

  public UserResource userId(String userId) {
    this.userId = userId;
    return this;
  }

  /**
   * Get userId
   * @return userId
  */
  
  @Schema(name = "userId", required = false)
  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
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
    return Objects.equals(this.userId, userResource.userId) &&
        Objects.equals(this.password, userResource.password) &&
        Objects.equals(this.isValid, userResource.isValid) &&
        Objects.equals(this.userDetail, userResource.userDetail);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, password, isValid, userDetail);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResource {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
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

