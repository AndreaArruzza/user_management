package com.savemoney.usermanagement.contract.model.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UpdateUserResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-20T19:00:23.887421100+01:00[Europe/Berlin]")
public class UpdateUserResource   {

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("isUpdateUser")
  private Boolean isUpdateUser;

  public UpdateUserResource userId(String userId) {
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

  public UpdateUserResource isUpdateUser(Boolean isUpdateUser) {
    this.isUpdateUser = isUpdateUser;
    return this;
  }

  /**
   * Get isUpdateUser
   * @return isUpdateUser
  */
  
  @Schema(name = "isUpdateUser", required = false)
  public Boolean getIsUpdateUser() {
    return isUpdateUser;
  }

  public void setIsUpdateUser(Boolean isUpdateUser) {
    this.isUpdateUser = isUpdateUser;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateUserResource updateUserResource = (UpdateUserResource) o;
    return Objects.equals(this.userId, updateUserResource.userId) &&
        Objects.equals(this.isUpdateUser, updateUserResource.isUpdateUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, isUpdateUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateUserResource {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    isUpdateUser: ").append(toIndentedString(isUpdateUser)).append("\n");
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

