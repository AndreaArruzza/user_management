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
 * CheckUserExistsResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-20T19:00:23.887421100+01:00[Europe/Berlin]")
public class CheckUserExistsResource   {

  @JsonProperty("isUserExists")
  private Boolean isUserExists;

  public CheckUserExistsResource isUserExists(Boolean isUserExists) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckUserExistsResource checkUserExistsResource = (CheckUserExistsResource) o;
    return Objects.equals(this.isUserExists, checkUserExistsResource.isUserExists);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isUserExists);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckUserExistsResource {\n");
    sb.append("    isUserExists: ").append(toIndentedString(isUserExists)).append("\n");
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

