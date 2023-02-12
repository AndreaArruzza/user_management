/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (5.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.savemoney.usermanagement.contract.api.v1;

import com.savemoney.usermanagement.contract.model.v1.CheckUserExistsResource;
import com.savemoney.usermanagement.contract.model.v1.CreateUserResource;
import com.savemoney.usermanagement.contract.model.v1.UpdateUserResource;
import com.savemoney.usermanagement.contract.model.v1.UserDto;
import com.savemoney.usermanagement.contract.model.v1.UserResource;
import com.savemoney.usermanagement.contract.model.v1.UsersResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-01-20T19:00:23.887421100+01:00[Europe/Berlin]")
@Validated
@Tag(name = "user-management", description = "the user-management API")
public interface UserManagementApi {

    /**
     * GET /user-management/v1/check-user-exists : check if existing an user by id and email
     *
     * @param id  (optional)
     * @param email  (optional)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "checkUserExists",
        summary = "check if existing an user by id and email",
        tags = { "user-management-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  CheckUserExistsResource.class))),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user-management/v1/check-user-exists",
        produces = { "application/json" }
    )
    ResponseEntity<CheckUserExistsResource> checkUserExists(
        @Parameter(name = "id", description = "", schema = @Schema(description = "")) @Valid @RequestParam(value = "id", required = false) String id,
        @Parameter(name = "email", description = "", schema = @Schema(description = "")) @Valid @RequestParam(value = "email", required = false) String email
    );


    /**
     * POST /user-management/v1/create-user : Create a new user
     *
     * @param userDto new user dto (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "createUser",
        summary = "Create a new user",
        tags = { "user-management-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  CreateUserResource.class))),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/user-management/v1/create-user",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CreateUserResource> createUser(
        @Parameter(name = "UserDto", description = "new user dto", required = true, schema = @Schema(description = "")) @Valid @RequestBody UserDto userDto
    );


    /**
     * GET /user-management/v1/users/{id} : get a user by id
     *
     * @param id  (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "getUserById",
        summary = "get a user by id",
        tags = { "user-management-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  UserResource.class))),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user-management/v1/users/{id}",
        produces = { "application/json" }
    )
    ResponseEntity<UserResource> getUserById(
        @Parameter(name = "id", description = "", required = true, schema = @Schema(description = "")) @PathVariable("id") Long id
    );


    /**
     * GET /user-management/v1/users : get a list of user
     *
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "getUsers",
        summary = "get a list of user",
        tags = { "user-management-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  UsersResource.class))),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/user-management/v1/users",
        produces = { "application/json" }
    )
    ResponseEntity<UsersResource> getUsers(
        
    );


    /**
     * PUT /user-management/v1/update-user : update an existing user
     *
     * @param userDto update user dto (required)
     * @return OK (status code 200)
     *         or Created (status code 201)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Not found (status code 404)
     */
    @Operation(
        operationId = "updateUser",
        summary = "update an existing user",
        tags = { "user-management-controller" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = @Content(mediaType = "application/json", schema = @Schema(implementation =  UpdateUserResource.class))),
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "401", description = "Unauthorized"),
            @ApiResponse(responseCode = "403", description = "Forbidden"),
            @ApiResponse(responseCode = "404", description = "Not found")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/user-management/v1/update-user",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<UpdateUserResource> updateUser(
        @Parameter(name = "UserDto", description = "update user dto", required = true, schema = @Schema(description = "")) @Valid @RequestBody UserDto userDto
    );

}