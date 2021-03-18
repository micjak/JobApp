package com.mj.jobapp.factory.joboffer;

import com.mj.jobapp.api.dto.joboffer.JobOfferDto;
import com.mj.jobapp.domain.joboffer.JobOffer;
import com.mj.jobapp.domain.joboffer.JobOfferCategory;
import com.mj.jobapp.domain.user.User;
import org.springframework.stereotype.Component;

import static java.util.Date.from;

@Component
public class JobOfferFactory {

    public JobOffer createJobOffer(JobOfferDto dto, User user){
        JobOffer jobOffer = new JobOffer();
        jobOffer.setCategory(JobOfferCategory.valueOf(dto.getCategory()));
        jobOffer.setStartDate(from(dto.getStartDate()));
        jobOffer.setEndDate(from(dto.getEndDate()));
        jobOffer.setUser(user);
        return jobOffer;
    }
}
