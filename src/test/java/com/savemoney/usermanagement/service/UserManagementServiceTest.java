package com.savemoney.usermanagement.service;

import com.savemoney.usermanagement.ApplicationTestConfig;
import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.model.v1.UpdateUserDto;
import com.savemoney.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ContextConfiguration(classes = {ApplicationTestConfig.class})
@SpringBootTest
public class UserManagementServiceTest {

    @MockBean
    private UserRepository repository;

    @Autowired
    private UserManagementService service;

    @Test
    void getUsers_OK(){
       when(repository.findAllByIsValidIsTrue()).thenReturn(List.of(createUser()));
       assertFalse(CollectionUtils.isEmpty(service.getUsers()));
    }

    @Test
    void getUsers_KO(){
        when(repository.findAllByIsValidIsTrue()).thenReturn(new ArrayList<>());
        assertThrows(ResponseStatusException.class, () -> service.getUsers());
    }

    @Test
    void getUserById_OK(){
        when(repository.findByIdAndIsValidIsTrue(anyLong())).thenReturn(Optional.of(createUser()));
        assertFalse(ObjectUtils.isEmpty(service.getUserById(1L,true)));
    }

    @Test
    void getUserById_KO(){
        when(repository.findByIdAndIsValidIsTrue(anyLong())).thenReturn(Optional.empty());
        assertThrows(ResponseStatusException.class, () -> service.getUserById(1L,true));
    }

    @Test
    void getUserById_OK_withoutDetails(){
        User user = new User();
        user.setEmail("andrearru@hotmail.it");
        user.setPassword("password");
        user.setIsValid(true);
        UserDetail userDetail = new UserDetail();
        user.setUserDetail(userDetail);
        when(repository.findByIdAndIsValidIsTrue(anyLong())).thenReturn(Optional.of(user));
        assertTrue(ObjectUtils.isEmpty(service.getUserById(1L,false).getUserDetail()));
    }

    @Test
    void checkUserExists_OK(){
        when(repository.findByIsValidIsTrueAndIdAndEmail(anyLong(),anyString())).thenReturn(Optional.of(createUser()));
        assertEquals(Boolean.TRUE, service.checkUserExists(1L, "andrearru@hotmail.it").getIsUserExists());
    }

    @Test
    void checkUserExists_OK_WithoutEmail(){
        when(repository.findByIsValidIsTrueAndIdOrEmail(anyLong(),anyString())).thenReturn(Optional.of(createUser()));
        assertEquals(Boolean.TRUE, service.checkUserExists(1L, "").getIsUserExists());
    }


    @Test
    void insertUser_OK(){
        when(repository.save(any())).thenReturn(createUser());
        assertEquals(1L, service.insertUser(createUser()));
    }

    @Test
    void updateUser_OK(){
        when(repository.findByIdAndIsValidIsTrue(anyLong())).thenReturn(Optional.of(createUser()));
        when(repository.save(any())).thenReturn(createUser());
        UpdateUserDto userDto = new UpdateUserDto();
        userDto.setId(1l);
        userDto.setPassword("password");
        userDto.setIsValid(true);
        userDto.setId(1L);
        userDto.setName("Andrea");
        userDto.setSurname("Arruzza");
        userDto.setCountry("Italy");
        userDto.setAddress("Corso Telesio 72");
        assertEquals("update is OK!", service.updateUser(userDto));
    }

    private User createUser() {
        User user = new User();
        user.setEmail("andrearru@hotmail.it");
        user.setPassword("password");
        user.setIsValid(true);
        user.setId(1L);
        UserDetail userDetail = new UserDetail();
        userDetail.setName("Andrea");
        userDetail.setSurname("Arruzza");
        userDetail.setCountry("Italy");
        userDetail.setAddress("Corso Telesio 72");
        user.setUserDetail(userDetail);

        return user;
    }
}
