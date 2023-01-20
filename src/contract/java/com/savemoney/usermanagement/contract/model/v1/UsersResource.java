package com.savemoney.usermanagement.contract.model.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.savemoney.usermanagement.contract.model.v1.UserResource;
import java.util.ArrayList;
import java.util.List;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UsersResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-20T19:00:23.887421100+01:00[Europe/Berlin]")
public class UsersResource   {

  @JsonProperty("UsersList")
  @Valid
  private List<UserResource> usersList = null;

  public UsersResource usersList(List<UserResource> usersList) {
    this.usersList = usersList;
    return this;
  }

  public UsersResource addUsersListItem(UserResource usersListItem) {
    if (this.usersList == null) {
      this.usersList = new ArrayList<>();
    }
    this.usersList.add(usersListItem);
    return this;
  }

  /**
   * Get usersList
   * @return usersList
  */
  @Valid 
  @Schema(name = "UsersList", required = false)
  public List<UserResource> getUsersList() {
    return usersList;
  }

  public void setUsersList(List<UserResource> usersList) {
    this.usersList = usersList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UsersResource usersResource = (UsersResource) o;
    return Objects.equals(this.usersList, usersResource.usersList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(usersList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UsersResource {\n");
    sb.append("    usersList: ").append(toIndentedString(usersList)).append("\n");
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

