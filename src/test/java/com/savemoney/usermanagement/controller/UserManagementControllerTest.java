package com.savemoney.usermanagement.controller;

import com.savemoney.usermanagement.ApplicationTestConfig;
import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.model.v1.CheckIfUserExistsDto;
import com.savemoney.usermanagement.model.v1.CheckIfUserExistsResource;
import com.savemoney.usermanagement.model.v1.NewUserDto;
import com.savemoney.usermanagement.model.v1.UpdateUserDto;
import com.savemoney.usermanagement.service.UserManagementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ApplicationTestConfig.class})
@SpringBootTest
public class UserManagementControllerTest {

    @MockBean
    private UserManagementService service;

    @Autowired
    private UserManagementController controller;

    @Test
    void getUsers_OK(){
        List<User> users = new ArrayList<>();
        users.add(createUser());
        when(service.getUsers()).thenReturn(users);
        assertFalse(CollectionUtils.isEmpty(Objects.requireNonNull(controller.getUsers().getBody()).getUsersList()));
    }

    @Test
    void getUser_OK(){
        when(service.getUserById(anyLong(),anyBoolean())).thenReturn(createUser());
        assertFalse(ObjectUtils.isEmpty(controller.getUserById(1L, true).getBody()));
    }

    @Test
    void checkIfUserExists_OK(){
        CheckIfUserExistsResource resource = new CheckIfUserExistsResource();
        resource.setId(1L);
        resource.setIsUserExists(true);
        resource.setEmail("andrearru@hotmail.it");

        CheckIfUserExistsDto dto = new CheckIfUserExistsDto();
        dto.setEmail("andreaarru@hotmail.it");
        dto.setId(1L);
        when(service.checkUserExists(anyLong(), anyString())).thenReturn(resource);
        assertEquals(resource.getIsUserExists(), Objects.requireNonNull((controller.checkIfUserExists(dto)).getBody()).getIsUserExists());
    }

    @Test
    void insertUser_OK(){
        Long newId = 10L;
        NewUserDto newUserDto = new NewUserDto();
        newUserDto.setEmail("email");
        newUserDto.setAddress("address");
        newUserDto.setPassword("password");
        newUserDto.setName("name");
        newUserDto.setSurname("surname");
        when(service.insertUser(any())).thenReturn(newId);

        assertEquals(newId, Objects.requireNonNull(controller.insertUser(newUserDto).getBody()).getId());
    }

    @Test
    void updateUser_OK(){
        UpdateUserDto updateUserDto = new UpdateUserDto();
        updateUserDto.setId(1L);
        updateUserDto.setAddress("address");
        updateUserDto.setPassword("password");
        updateUserDto.setName("name");
        updateUserDto.setSurname("surname");

        when(service.updateUser(any())).thenReturn("update is OK!");
        assertEquals("update is OK!", Objects.requireNonNull(controller.updateUser(updateUserDto).getBody()).getMessage());
    }

    private User createUser() {
        User user = new User();
        user.setEmail("andrearru@hotmail.it");
        user.setPassword("password");
        user.setIsValid(true);
        UserDetail userDetail = new UserDetail();
        userDetail.setName("Andrea");
        userDetail.setSurname("Arruzza");
        userDetail.setCountry("Italy");
        userDetail.setAddress("Corso Telesio 72");
        user.setUserDetail(userDetail);

        return user;
    }
}
