package com.mj.jobapp.converter.user;

import com.mj.jobapp.api.dto.user.UserOutDto;
import com.mj.jobapp.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserOutDto toDto(User user){
        UserOutDto dto = new UserOutDto();
        dto.setLogin(user.getLogin());
        dto.setName(user.getName());
        dto.setAccountCreateDate(user.getAccountCreateDate().toInstant());
        dto.setPassword(user.getPassword());
        return dto;
    }
}
