package com.mj.jobapp.api.dto.user;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data
public class UserOutDto implements Serializable {

    private static final long serialVersionUID = -8512994335583608829L;

    private String login;
    private String name;
    private String password;
    private Instant accountCreateDate;

}