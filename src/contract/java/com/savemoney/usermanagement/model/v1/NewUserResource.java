package com.savemoney.usermanagement.model.v1;

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
 * NewUserResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-13T19:41:36.166055+01:00[Europe/Rome]")
public class NewUserResource   {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("isCreatedUser")
  private Boolean isCreatedUser;

  public NewUserResource id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", required = false)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public NewUserResource isCreatedUser(Boolean isCreatedUser) {
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
    NewUserResource newUserResource = (NewUserResource) o;
    return Objects.equals(this.id, newUserResource.id) &&
        Objects.equals(this.isCreatedUser, newUserResource.isCreatedUser);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, isCreatedUser);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewUserResource {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

