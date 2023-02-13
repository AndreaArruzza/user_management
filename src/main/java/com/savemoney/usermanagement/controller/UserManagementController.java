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
        logger.info("UserManagementController.getUsers....");
        UsersResource resource = new UsersResource();
        resource.setUsersList(mapper.entityListToResource(service.getUsers()));
        logger.info("UserManagementController.getUsers result => {}", resource);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<UserResource> getUserById(Long id, Boolean details) {
        logger.info("UserManagementController.getUserById with input {} {}  ....", id, details);
        UserResource resource = mapper.entityToResource(service.getUserById(id, details));
        logger.info("UserManagementController.getUserById result => {}", resource);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<CheckIfUserExistsResource> checkIfUserExists(CheckIfUserExistsDto checkIfUserExistsDto) {
        logger.info("UserManagementController.checkIfUserExists with input.... {}", checkIfUserExistsDto);
        CheckIfUserExistsResource resource = service.checkUserExists(checkIfUserExistsDto.getId(),checkIfUserExistsDto.getEmail());
        logger.info("UserManagementController.updateUser with result => {}", resource);
        return ResponseEntity.ok(resource);
    }


    @Override
    public ResponseEntity<NewUserResource> insertUser(NewUserDto newUserDto) {
        NewUserResource resource = new NewUserResource();
        logger.info("insert new user with input {}....", newUserDto);
        Long newId = service.insertUser(mapper.dtoToEntity(newUserDto));
        resource.setIsCreatedUser(newId != null);
        resource.setId(newId);
        logger.info("insert new user with id {}", newId);
        return ResponseEntity.ok(resource);
    }

    @Override
    public ResponseEntity<UpdateUserResource> updateUser(UpdateUserDto updateUserDto) {
        logger.info("UserManagementController.updateUser with input.... {}", updateUserDto);
        UpdateUserResource resource = new UpdateUserResource();
        resource.setMessage(service.updateUser(updateUserDto));
        logger.info("UserManagementController.updateUser with result => {}", resource);
        return ResponseEntity.ok(resource);
    }

}