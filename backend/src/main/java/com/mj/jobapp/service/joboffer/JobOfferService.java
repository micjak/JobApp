package com.mj.jobapp.service.joboffer;

import java.util.List;

import com.mj.jobapp.api.dto.joboffer.JobOfferDto;

public interface JobOfferService {

    void createJobOffer(JobOfferDto dto);

    List<JobOfferDto> getValidOffersByFilters(String userName, String category) throws Exception;

}
