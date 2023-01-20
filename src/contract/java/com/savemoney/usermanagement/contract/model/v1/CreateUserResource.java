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
 * CreateUserResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-20T19:00:23.887421100+01:00[Europe/Berlin]")
public class CreateUserResource   {

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("isCreatedUser")
  private Boolean isCreatedUser;

  public CreateUserResource userId(String userId) {
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

  public CreateUserResource isCreatedUser(Boolean isCreatedUser) {
    this.isCreatedUser = isCreatedUser;
    return this;
  }

  /**
   * Get isCreatedUser
   * @return isCreatedUser
  */
  
  @Schema(name = "isCreatedUser", required = false)
  public Boolean getIsCreatedUser() {
    return isCreatedUser;
  }

  public void setIsCreatedUser(Boolean isCreatedUser) {
    this.isCreatedUser = isCreatedUser;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUserResource createUserResource = (CreateUserResource) o;
    return Objects.equals(this.userId, createUserResource.userId) &&
        Objects.equals(this.isCreatedUser, createUserResource.isCreatedUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, isCreatedUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUserResource {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    isCreatedUser: ").append(toIndentedString(isCreatedUser)).append("\n");
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

