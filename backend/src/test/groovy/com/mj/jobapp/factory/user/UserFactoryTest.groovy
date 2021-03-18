package com.mj.jobapp.factory.user


import com.mj.jobapp.api.dto.user.UserInDto
import com.mj.jobapp.domain.user.User
import spock.lang.Specification

class UserFactoryTest extends Specification {

    private static final String LOGIN = "UserLogin"
    private static final String PASSWORD = "UserPassword"
    private static final String NAME = "UserName"
    private static

    UserFactory factory = new UserFactory()

    def "Should create new User entity from dto"() {
        given:
        UserInDto dto = mockUserDto()

        when:
        User user = factory.createUser(dto)

        then:
        user != null
        user.login == dto.login
        user.password == dto.password
        user.name == dto.name
    }

    def "Should update existing User with login and password"() {
        given:
        UserInDto dto = mockUserDto()
        User user = mockUser()

        when:
        User updatedUser = factory.updateUser(user, dto)

        then:
        updatedUser != null
        updatedUser.id == user.id
        updatedUser.login == dto.login
        updatedUser.password == dto.password
        updatedUser.name == dto.name
    }


    UserInDto mockUserDto() {
        UserInDto dto = new UserInDto()
        dto.setLogin(LOGIN)
        dto.setPassword(PASSWORD)
        dto.setName(NAME)
        return dto
    }

    User mockUser() {
        User user = new User()
        user.setId(1L)
        user.setLogin("CurrentLogin")
        user.setPassword("CurrentPassword")
        user.setName(NAME)
        return user
    }

}
