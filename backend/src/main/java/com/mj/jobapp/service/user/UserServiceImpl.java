package com.mj.jobapp.service.user;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.mj.jobapp.api.dto.user.UserInDto;
import com.mj.jobapp.api.dto.user.UserOutDto;
import com.mj.jobapp.converter.user.UserConverter;
import com.mj.jobapp.domain.user.User;
import com.mj.jobapp.factory.user.UserFactory;
import com.mj.jobapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserConverter converter;
    private final UserRepository repository;
    private final UserFactory factory;

    @Override
    public List<UserOutDto> getAllUsers() {
        List<User> users = repository.findAll();
        return users.stream().map(converter::toDto).collect(Collectors.toList());
    }

    @Override
    public UserOutDto getUserById(Long id) throws Exception {
        Optional<User> user = repository.findById(id);
        //TODO: implement new Exception when user was not found in db (UserNotFoundException)
        return user.map(converter::toDto)
                   .orElseThrow(Exception::new);
    }

    @Override
    public void createUser(UserInDto userDto) {
        User user = factory.createUser(userDto);
        repository.save(user);
    }

    @Override
    public void updateUser(UserInDto dto) throws Exception {
        Optional<User> optionalUser = repository.findByName(dto.getName());
        //TODO: implement new Exception when user was not found in db (UserNotFoundException)
        User user = optionalUser.orElseThrow(Exception::new);
        factory.updateUser(user, dto);
        repository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        if(repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}
