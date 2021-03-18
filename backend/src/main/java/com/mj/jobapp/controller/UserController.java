package com.mj.jobapp.controller;

import java.util.List;

import com.mj.jobapp.api.dto.user.UserInDto;
import com.mj.jobapp.api.dto.user.UserOutDto;
import com.mj.jobapp.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class UserController {
    //TODO: move controllers from backend to separate module

    private final UserService userService;

    @GetMapping(value = "/users")
    public List<UserOutDto> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/by-id")
    public UserOutDto findUserById(Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/user")
    public void createUser(@RequestBody UserInDto userDto) {
        userService.createUser(userDto);
    }

    @PutMapping(value = "/user")
    public void updateUsers(UserInDto dto) throws Exception {
        userService.updateUser(dto);
    }

    @DeleteMapping(value = "/user")
    public void deleteUser(Long id) {
        userService.deleteUser(id);
    }
}
