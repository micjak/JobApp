package com.mj.jobapp.factory.joboffer

import com.mj.jobapp.api.dto.joboffer.JobOfferDto
import com.mj.jobapp.domain.joboffer.JobOffer
import com.mj.jobapp.domain.joboffer.JobOfferCategory
import com.mj.jobapp.domain.user.User
import spock.lang.Specification

import java.time.Instant
import java.time.temporal.ChronoUnit

class JobOfferFactoryTest extends Specification{

    private static final String USER_NAME = "UserName"

    JobOfferFactory factory = new JobOfferFactory()

    def "Should create new JobOffer from JobOfferDto"(){
        given:
        JobOfferDto dto = mockJobOfferDto()
        User user = mockUser()

        when:
        JobOffer jobOffer = factory.createJobOffer(dto, user)

        then:
        jobOffer != null
        jobOffer.user == user
        jobOffer.startDate == Date.from(dto.startDate)
        jobOffer.endDate == Date.from(dto.endDate)
        jobOffer.category.name() == dto.category

    }

    static JobOfferDto mockJobOfferDto() {
        JobOfferDto dto = new JobOfferDto()
        dto.setCategory(JobOfferCategory.IT.name())
        dto.setStartDate(Instant.now())
        dto.setEndDate(Instant.now().plus(3, ChronoUnit.DAYS))
        dto.setUserName(USER_NAME)
        return dto
    }

    static User mockUser(){
        User user = new User()
        user.setId(11L)
        user.setAccountCreateDate(new Date())
        user.setName(USER_NAME)
        user.setLogin("UserLogin")
        user.setPassword("UserPassword")
        return user
    }


}
