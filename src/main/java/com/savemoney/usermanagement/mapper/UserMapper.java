package com.savemoney.usermanagement.mapper;

import com.savemoney.usermanagement.model.CheckUserExistsModel;
import org.mapstruct.Mapper;

@Mapper(componentModel =  "spring")
public interface UserMapper {

    CheckUserExistsModel dtoToOutputModel(String email, String userId, String password);
}
