package com.savemoney.usermanagement.contract.model.v1;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * UserResource
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-20T19:00:23.887421100+01:00[Europe/Berlin]")
public class UserResource   {

  @JsonProperty("userId")
  private String userId;

  @JsonProperty("name")
  private String name;

  @JsonProperty("surname")
  private String surname;

  @JsonProperty("birthDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  @JsonProperty("birthPlace")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthPlace;

  @JsonProperty("address")
  private String address;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("email")
  private String email;

  @JsonProperty("phone")
  private String phone;

  @JsonProperty("password")
  private String password;

  @JsonProperty("isValid")
  private Boolean isValid;

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

  public UserResource name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", required = false)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public UserResource surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
  */
  
  @Schema(name = "surname", required = false)
  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public UserResource birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Get birthDate
   * @return birthDate
  */
  @Valid 
  @Schema(name = "birthDate", required = false)
  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public UserResource birthPlace(LocalDate birthPlace) {
    this.birthPlace = birthPlace;
    return this;
  }

  /**
   * Get birthPlace
   * @return birthPlace
  */
  @Valid 
  @Schema(name = "birthPlace", required = false)
  public LocalDate getBirthPlace() {
    return birthPlace;
  }

  public void setBirthPlace(LocalDate birthPlace) {
    this.birthPlace = birthPlace;
  }

  public UserResource address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
  */
  
  @Schema(name = "address", required = false)
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public UserResource postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  
  @Schema(name = "postalCode", required = false)
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
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

  public UserResource phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
  */
  
  @Schema(name = "phone", required = false)
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
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
        Objects.equals(this.name, userResource.name) &&
        Objects.equals(this.surname, userResource.surname) &&
        Objects.equals(this.birthDate, userResource.birthDate) &&
        Objects.equals(this.birthPlace, userResource.birthPlace) &&
        Objects.equals(this.address, userResource.address) &&
        Objects.equals(this.postalCode, userResource.postalCode) &&
        Objects.equals(this.email, userResource.email) &&
        Objects.equals(this.phone, userResource.phone) &&
        Objects.equals(this.password, userResource.password) &&
        Objects.equals(this.isValid, userResource.isValid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, name, surname, birthDate, birthPlace, address, postalCode, email, phone, password, isValid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserResource {\n");
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
    sb.append("    birthPlace: ").append(toIndentedString(birthPlace)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
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

