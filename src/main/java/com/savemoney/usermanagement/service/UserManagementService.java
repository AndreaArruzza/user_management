package com.savemoney.usermanagement.service;

import com.savemoney.usermanagement.contract.model.v1.*;
import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.model.CheckUserExistsModel;
import com.savemoney.usermanagement.repository.UserRepository;
import net.bytebuddy.asm.Advice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserManagementService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepository userRepository;

    public UserResource getUserById(Long userId) {
        userRepository.findById(userId);
    }

    public UsersResource getUsers() {
        userRepository.findAll();
    }

    public String updateUser(UserDto updateUserDto) {
        User user = new User();
        user.setId(updateUserDto.getId());
        user.setEmail(updateUserDto.getEmail());
        user.setPassword(updateUserDto.getPassword());
        user.setIsValid(updateUserDto.getIsValid());

        UserDetail userDetail = new UserDetail();
        userDetail.setName(updateUserDto.getName());
        userDetail.setSurname(updateUserDto.getSurname());
        userDetail.setBirthDate(updateUserDto.getBirthDate());
        userDetail.setBirthPlace(updateUserDto.getBirthPlace());
        user.setUserDetail(userDetail);

        userRepository.save(user);
    }

    public String createUser(UserDto createUserDto) {
        User user = new User();
        user.setId(createUserDto.getId());
        user.setEmail(createUserDto.getEmail());
        user.setPassword(createUserDto.getPassword());
        user.setIsValid(createUserDto.getIsValid());
        user.setUserDetail(new UserDetail());

        userRepository.save(user);
    }

    public Boolean checkUserExists(String userId, String email) {
        Optional<User> user = userRepository.findByIdAndEmail(userId,email);
        CheckUserExistsResource resource = new CheckUserExistsResource();
        return (user.isPresent()) ? Boolean.TRUE : Boolean.FALSE;
    }
}
