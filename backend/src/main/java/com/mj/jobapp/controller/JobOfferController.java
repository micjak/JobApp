package com.mj.jobapp.controller;

import java.util.List;

import com.mj.jobapp.api.dto.joboffer.JobOfferDto;
import com.mj.jobapp.service.joboffer.JobOfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class JobOfferController {
    //TODO: move controllers from backend to separate module

    private final JobOfferService service;

    @PostMapping(value = "/job-offer")
    public void createJobOffer(@RequestBody JobOfferDto dto) {
        //TODO: add response and exception handling
        service.createJobOffer(dto);
    }

    @GetMapping(value = "/job-offers")
    public List<JobOfferDto> getValidJobOffersWithFilter(@RequestParam(required = false) String userName,
                                                         @RequestParam(required = false) String category) throws Exception {
        return service.getValidOffersByFilters(userName, category);
    }
}
