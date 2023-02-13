package com.savemoney.usermanagement.mapper;

import com.savemoney.usermanagement.entity.User;
import com.savemoney.usermanagement.entity.UserDetail;
import com.savemoney.usermanagement.model.CheckUserExistsModel;
import com.savemoney.usermanagement.model.v1.NewUserDto;
import com.savemoney.usermanagement.model.v1.UserDetailResource;
import com.savemoney.usermanagement.model.v1.UserResource;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface UserMapper {
    CheckUserExistsModel dtoToOutputModel(String email, String userId, String password);

    UserDetailResource entityDetailToResourceDetail(UserDetail userDetail);
    UserResource entityToResource(User user);
    List<UserResource> entityListToResource(List<User> users);

    User dtoToEntity(NewUserDto userDto);
}
