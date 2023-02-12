package com.savemoney.usermanagement.service;

import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.mapper.UserMapper;
import com.savemoney.usermanagement.model.v1.UserDto;
import com.savemoney.usermanagement.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Service
public class UserManagementService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;


    public User getUserById(Long userId, Boolean details) {
        User user = userRepository.findByIdAndIsValidIsTrue(userId).orElseThrow(() -> new RuntimeException("no user found"));
        //todo creare custom exception
        if(!details){
            user.setUserDetail(null);
        }
        return user;
    }

    public List<User> getUsers() {
        List<User> users =  userRepository.findAllByIsValidIsTrue();
        if(CollectionUtils.isEmpty(users)) throw new RuntimeException("empty list");
        return users;
    }

    @Transactional
    public String updateUser(UserDto userDto) {
        Optional<User> u = userRepository.findByIdAndIsValidIsTrue(userDto.getId());
        User userbyId = u.orElseThrow(() -> new RuntimeException("no user found"));

        userbyId.setEmail(userDto.getEmail());
        userbyId.setPassword(userDto.getPassword());
        userbyId.setIsValid(userDto.getIsValid());

        userbyId.getUserDetail().setName(userDto.getName());
        userbyId.getUserDetail().setSurname(userDto.getSurname());
        userbyId.getUserDetail().setBirthPlace(userDto.getBirthPlace());
        userbyId.getUserDetail().setBirthDate(userDto.getBirthDate());
        userbyId.getUserDetail().setAddress(userDto.getAddress());
        userbyId.getUserDetail().setPhone(userDto.getPhone());
        userRepository.save(userbyId);
        return "update is OK!";
    }

    @Transactional
    public Long createUser(User newUser) {
        UserDetail userDetail = new UserDetail();
        newUser.setUserDetail(userDetail);
        User insertedUser = userRepository.save(newUser);
        return insertedUser.getId();
    }

    public Boolean checkUserExists(Long userId, String email) {
        Optional<User> user = userRepository.findByIsValidIsTrueAndIdOrEmail(userId,email);
        return (user.isPresent()) ? Boolean.TRUE : Boolean.FALSE;
    }
}
