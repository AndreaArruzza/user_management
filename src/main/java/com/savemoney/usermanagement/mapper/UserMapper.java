package com.savemoney.usermanagement.mapper;

import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.model.CheckUserExistsModel;
import com.savemoney.usermanagement.model.v1.NewUser;
import com.savemoney.usermanagement.model.v1.UserDetailResource;
import com.savemoney.usermanagement.model.v1.UserDto;
import com.savemoney.usermanagement.model.v1.UserResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface UserMapper {
    CheckUserExistsModel dtoToOutputModel(String email, String userId, String password);

    UserDetailResource entityDetailToResourceDetail(UserDetail userDetail);
    @Mapping(target = "userId", source ="id")
    UserResource entityToResource(User user);
    List<UserResource> entityListToResource(List<User> users);

    UserDetail dtoToUserDetail(UserDto usertDto);
    //TODO CONTROLLARE USERDETAIL
    User dtoToEntity(UserDto userDto);
    User dtoToEntity(NewUser userDto);
    /*UserDetail userDetail = new UserDetail();
        userDetail.setName(updateUserDto.getName());
        userDetail.setSurname(updateUserDto.getSurname());
        userDetail.setBirthDate(updateUserDto.getBirthDate());
        userDetail.setBirthPlace(updateUserDto.getBirthPlace());
        user.setUserDetail(userDetail);*/
}
