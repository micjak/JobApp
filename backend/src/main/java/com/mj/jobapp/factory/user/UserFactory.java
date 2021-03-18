package com.mj.jobapp.factory.user;

import com.mj.jobapp.api.dto.user.UserInDto;
import com.mj.jobapp.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserFactory {

    public User createUser(UserInDto dto){
        User user = new User();
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        //TODO: password should be encrypted, add encrypt mechanism
        user.setPassword(dto.getPassword());
        return user;
    }

    public User updateUser(User user, UserInDto dto){
        user.setLogin(dto.getLogin());
        user.setName(dto.getName());
        //TODO: password should be encrypted, add encrypt mechanism
        user.setPassword(dto.getPassword());
        return user;
    }
}
