package com.savemoney.usermanagement.model;

import lombok.Data;

@Data
public class CheckUserExistsModel {
    private String email;
    private String userId;
    private String password;
}
