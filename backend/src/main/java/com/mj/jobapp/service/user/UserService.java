package com.mj.jobapp.service.user;

import java.util.List;

import com.mj.jobapp.api.dto.user.UserInDto;
import com.mj.jobapp.api.dto.user.UserOutDto;

public interface UserService {

    List<UserOutDto> getAllUsers();

    UserOutDto getUserById(Long id) throws Exception;

    void createUser(UserInDto userDto);

    void updateUser(UserInDto dto) throws Exception;

    void deleteUser(Long id);

}
