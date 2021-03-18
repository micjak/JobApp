package com.mj.jobapp.api.dto.user;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInDto implements Serializable {

    private static final long serialVersionUID = -3626750359482081172L;

    private String login;
    private String name;
    private String password;
}
