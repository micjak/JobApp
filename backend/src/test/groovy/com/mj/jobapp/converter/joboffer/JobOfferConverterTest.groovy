package com.mj.jobapp.converter.joboffer

import com.mj.jobapp.api.dto.joboffer.JobOfferDto
import com.mj.jobapp.domain.joboffer.JobOffer
import com.mj.jobapp.domain.joboffer.JobOfferCategory
import com.mj.jobapp.domain.user.User
import spock.lang.Specification

class JobOfferConverterTest extends Specification{

    JobOfferConverter converter = new JobOfferConverter()

    def "Should convert JobOffer to JobOfferDto" (){
        given:
        JobOffer jobOffer = mockJobOffer()

        when:
        JobOfferDto dto = converter.toDto(jobOffer)

        then:
        jobOffer != null
        dto.category == jobOffer.category.name()
        dto.endDate == jobOffer.endDate.toInstant()
        dto.startDate == jobOffer.startDate.toInstant()
        dto.userName == jobOffer.user.name
    }

    def "Should not throw exception when user is null for jobOffer" (){
        given:
        JobOffer jobOffer = mockJobOffer()
        jobOffer.setUser(null)

        when:
        converter.toDto(jobOffer)

        then:
        thrown Exception
    }



    JobOffer mockJobOffer() {
        JobOffer jobOffer = new JobOffer()
        jobOffer.setId(1L)
        jobOffer.setCategory(JobOfferCategory.IT)
        jobOffer.setStartDate(new Date())
        jobOffer.setEndDate(new Date().plus(3))
        jobOffer.setUser(mockUser())
        return jobOffer
    }

    User mockUser(){
        User user = new User()
        user.setId(11L)
        user.setAccountCreateDate(new Date())
        user.setName("UserName")
        user.setLogin("UserLogin")
        user.setPassword("UserPassword")
        return user
    }
}