package com.savemoney.usermanagement.service;

import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.mapper.UserMapper;
import com.savemoney.usermanagement.model.v1.CheckIfUserExistsResource;
import com.savemoney.usermanagement.model.v1.UserDto;
import com.savemoney.usermanagement.repository.UserRepository;
import org.apache.commons.lang3.ObjectUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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


    public User getUserById(Long userId, Boolean details) {
        User user = userRepository.findByIdAndIsValidIsTrue(userId).orElseThrow(() -> new RuntimeException("user not found"));
        //todo creare custom exception
        if(!details){
            user.setUserDetail(null);
        }
        logger.info("get user by id {}", user);
        return user;
    }

    public List<User> getUsers() {
        List<User> users =  userRepository.findAllByIsValidIsTrue();
        if(CollectionUtils.isEmpty(users)) throw new RuntimeException("empty list");
        logger.info("get users {}", users);
        return users;
    }

    @Transactional
    public String updateUser(UserDto userDto) {
            User userbyId = getUserById(userDto.getId(),false);
            userbyId.setPassword(userDto.getPassword());
            userbyId.setIsValid(userDto.getIsValid());

            UserDetail userDetail = new UserDetail();
            userDetail.setName(userDto.getName());
            userDetail.setSurname(userDto.getSurname());
            userDetail.setBirthPlace(userDto.getBirthPlace());
            userDetail.setBirthDate(userDto.getBirthDate());
            userDetail.setAddress(userDto.getAddress());
            userDetail.setPhone(userDto.getPhone());

            userbyId.setUserDetail(userDetail);
        try {
            userRepository.save(userbyId);
            logger.info("update done");
            return "update is OK!";
        }
        catch(Exception e){
            logger.error(e.getLocalizedMessage());
            throw new RuntimeException(e.getLocalizedMessage());
        }
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
            throw new RuntimeException(e.getLocalizedMessage());
        }
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
}
