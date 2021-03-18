package com.mj.jobapp.converter.user

import com.mj.jobapp.api.dto.user.UserOutDto
import com.mj.jobapp.domain.user.User
import spock.lang.Specification

class UserConverterTest extends Specification {

    UserConverter converter = new UserConverter()

    def "Should convert User to UserOutDto"(){
        given:
        User user = mockUser()


        when:
        UserOutDto outDto = converter.toDto(user)

        then:
        outDto != null
        outDto.login == user.login
        outDto.name == user.name
        outDto.password == user.password
        outDto.accountCreateDate == user.accountCreateDate.toInstant()
    }

    User mockUser() {
        User user = new User()
        user.setId(1L)
        user.setAccountCreateDate(new Date())
        user.setName("UserName")
        user.setLogin("UserLogin")
        user.setPassword("UserPassword")
        return user
    }
}
