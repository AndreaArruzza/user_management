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
 * CheckIfUserExistsResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-13T19:41:36.166055+01:00[Europe/Rome]")
public class CheckIfUserExistsResource   {

  @JsonProperty("isUserExists")
  private Boolean isUserExists;

  @JsonProperty("id")
  private Long id;

  @JsonProperty("email")
  private String email;

  public CheckIfUserExistsResource isUserExists(Boolean isUserExists) {
    this.isUserExists = isUserExists;
    return this;
  }

  /**
   * Get isUserExists
   * @return isUserExists
  */
  
  @Schema(name = "isUserExists", required = false)
  public Boolean getIsUserExists() {
    return isUserExists;
  }

  public void setIsUserExists(Boolean isUserExists) {
    this.isUserExists = isUserExists;
  }

  public CheckIfUserExistsResource id(Long id) {
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

  public CheckIfUserExistsResource email(String email) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckIfUserExistsResource checkIfUserExistsResource = (CheckIfUserExistsResource) o;
    return Objects.equals(this.isUserExists, checkIfUserExistsResource.isUserExists) &&
        Objects.equals(this.id, checkIfUserExistsResource.id) &&
        Objects.equals(this.email, checkIfUserExistsResource.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isUserExists, id, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckIfUserExistsResource {\n");
    sb.append("    isUserExists: ").append(toIndentedString(isUserExists)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

