package com.savemoney.usermanagement.controller;

import com.savemoney.usermanagement.contract.api.v1.UserManagementApi;
import com.savemoney.usermanagement.contract.model.v1.*;
import com.savemoney.usermanagement.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController implements UserManagementApi {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserManagementService service;

    @Override
    public ResponseEntity<UserResource> getUserById(Long id) {
        UserResource resource = service.getUserById(id);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<UsersResource> getUsers() {
        UsersResource resource = service.getUsers();
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<UpdateUserResource> updateUser(UserDto userDto) {
        UpdateUserResource resource = service.updateUser(userDto);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<CheckUserExistsResource> checkUserExists(String id, String email) {
        CheckUserExistsResource resource = new CheckUserExistsResource();
        resource.setIsUserExists(service.checkUserExists(id, email););
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<CreateUserResource> createUser(UserDto createUserDto) {
        CreateUserResource resource = new CreateUserResource();
        resource.set
        return ResponseEntity.ok(resource);
    }

}
