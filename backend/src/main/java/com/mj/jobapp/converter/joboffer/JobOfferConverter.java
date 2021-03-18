package com.mj.jobapp.converter.joboffer;

import java.util.Optional;

import com.mj.jobapp.api.dto.joboffer.JobOfferDto;
import com.mj.jobapp.domain.joboffer.JobOffer;
import com.mj.jobapp.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class JobOfferConverter {

    public JobOfferDto toDto(JobOffer jobOffer) throws Exception {
        JobOfferDto dto = new JobOfferDto();
        dto.setCategory(jobOffer.getCategory().getOfferTypeName());
        dto.setStartDate(jobOffer.getStartDate().toInstant());
        dto.setEndDate(jobOffer.getEndDate().toInstant());
        //TODO: create dedicated Exception
        String userName = Optional.ofNullable(jobOffer.getUser()).map(User::getName).orElseThrow(Exception::new);
        dto.setUserName(userName);
        return dto;
    }
}
