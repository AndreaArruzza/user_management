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
 * NewUser
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-02-12T19:40:14.230716700+01:00[Europe/Rome]")
public class NewUser   {

  @JsonProperty("email")
  private String email;

  @JsonProperty("password")
  private String password;

  @JsonProperty("isValid")
  private Boolean isValid;

  public NewUser email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
  */
  @NotNull 
  @Schema(name = "email", required = true)
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public NewUser password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
  */
  @NotNull 
  @Schema(name = "password", required = true)
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public NewUser isValid(Boolean isValid) {
    this.isValid = isValid;
    return this;
  }

  /**
   * Get isValid
   * @return isValid
  */
  @NotNull 
  @Schema(name = "isValid", required = true)
  public Boolean getIsValid() {
    return isValid;
  }

  public void setIsValid(Boolean isValid) {
    this.isValid = isValid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewUser newUser = (NewUser) o;
    return Objects.equals(this.email, newUser.email) &&
        Objects.equals(this.password, newUser.password) &&
        Objects.equals(this.isValid, newUser.isValid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, password, isValid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewUser {\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    isValid: ").append(toIndentedString(isValid)).append("\n");
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

