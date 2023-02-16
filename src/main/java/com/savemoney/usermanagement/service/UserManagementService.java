package com.savemoney.usermanagement.service;

import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.mapper.UserMapper;
import com.savemoney.usermanagement.model.v1.CheckIfUserExistsResource;
import com.savemoney.usermanagement.model.v1.UpdateUserDto;
import com.savemoney.usermanagement.repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserManagementService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    public List<User> getUsers() {
        List<User> users =  userRepository.findAllByIsValidIsTrue();
        if(CollectionUtils.isEmpty(users)) {
            logger.error("users not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "users not found");
        }
        logger.info("get users {}", users);
        return users;
    }

    public User getUserById(Long userId, Boolean details) {
        User user = userRepository.findByIdAndIsValidIsTrue(userId).orElseThrow(() -> {
            logger.error("user not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found");
        });

        if(!details){
            user.setUserDetail(null);
        }
        logger.info("get user by id {}", user);
        return user;
    }

    public CheckIfUserExistsResource checkUserExists(Long userId, String email) {
        Optional<User> checkUser = Optional.empty();
        CheckIfUserExistsResource checkIfUserExistsResource = new CheckIfUserExistsResource();

        if(ObjectUtils.isNotEmpty(userId) && ObjectUtils.isNotEmpty(email)){
            checkUser = userRepository.findByIsValidIsTrueAndIdAndEmail(userId,email);
        }
        else if(ObjectUtils.isNotEmpty(userId) || ObjectUtils.isNotEmpty(email)){
            checkUser = userRepository.findByIsValidIsTrueAndIdOrEmail(userId,email);
        }

        logger.info("check user {}", checkUser);
        checkIfUserExistsResource.setIsUserExists((checkUser.isPresent()) ? Boolean.TRUE : Boolean.FALSE);
        checkIfUserExistsResource.setId(checkUser.map(User::getId).orElse(null));
        checkIfUserExistsResource.setEmail((checkUser.isPresent()) ? checkUser.get().getEmail() : "");
        return checkIfUserExistsResource;
    }

    @Transactional
    public Long insertUser(User newUser) {
        try{
            String encryptedPassword = passwordEncoder.encode(newUser.getPassword());
            newUser.setPassword(encryptedPassword);
            User insertedUser = userRepository.save(newUser);
            logger.info("insert done");
            return insertedUser.getId();
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

    @Transactional
    public String updateUser(UpdateUserDto userDto) {
            User userbyId = getUserById(userDto.getId(),false);
            userbyId.setPassword(userDto.getPassword());
            userbyId.setIsValid(userDto.getIsValid());
            if(ObjectUtils.isNotEmpty(userbyId.getUserDetail())){
                userbyId.getUserDetail().setName(userDto.getName());
                userbyId.getUserDetail().setSurname(userDto.getSurname());
                userbyId.getUserDetail().setBirthPlace(userDto.getBirthPlace());
                userbyId.getUserDetail().setBirthDate(userDto.getBirthDate());
                userbyId.getUserDetail().setAddress(userDto.getAddress());
                userbyId.getUserDetail().setPhone(userDto.getPhone());
            }
        try {
            userRepository.save(userbyId);
            logger.info("update done");
            return "update is OK!";
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage());
        }
    }

}
