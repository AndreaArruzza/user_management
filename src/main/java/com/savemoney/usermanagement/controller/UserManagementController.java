package com.savemoney.usermanagement.controller;

import com.savemoney.usermanagement.api.v1.UserManagementApi;
import com.savemoney.usermanagement.mapper.UserMapper;
import com.savemoney.usermanagement.model.v1.*;
import com.savemoney.usermanagement.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserManagementController implements UserManagementApi {
    @Autowired
    private UserMapper mapper;

    @Autowired
    private UserManagementService service;

    public final Logger logger = LoggerFactory.getLogger(this.getClass());



    @Override
    public ResponseEntity<UsersResource> getUsers() {
        logger.info("UserManagementController.getUse rs....");
        UsersResource resource = new UsersResource();
        resource.setUsersList(mapper.entityListToResource(service.getUsers()));
        logger.info("UserManagementController.getUsers result => {}", resource);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<UserResource> getUserById(Long id, Boolean details) {
        logger.info("UserManagementController.getUserById....");
        UserResource resource = mapper.entityToResource(service.getUserById(id, details));
        logger.info("UserManagementController.getUserById result => {}", resource);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<CheckIfUserExistsResource> checkIfUserExists(CheckIfUserExistsDto checkIfUserExistsDto) {
        CheckIfUserExistsResource resource = new CheckIfUserExistsResource();
        resource.setIsUserExists(service.checkUserExists(checkIfUserExistsDto.getId(),checkIfUserExistsDto.getEmail()));
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<CreateUserResource> createUser(NewUser newUser) {
        CreateUserResource resource = new CreateUserResource();
        Long newId = service.createUser(mapper.dtoToEntity(newUser));
        resource.setIsCreatedUser(newId != null);
        resource.setId(newId);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<UpdateUserResource> updateUser(UserDto userDto) {
        UpdateUserResource updateUserResource = new UpdateUserResource();
        updateUserResource.setMessage(service.updateUser(userDto));
        return ResponseEntity.ok(updateUserResource);
    }
}