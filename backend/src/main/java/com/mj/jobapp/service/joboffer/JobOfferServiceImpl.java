package com.mj.jobapp.service.joboffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mj.jobapp.api.dto.joboffer.JobOfferDto;
import com.mj.jobapp.converter.joboffer.JobOfferConverter;
import com.mj.jobapp.domain.joboffer.JobOffer;
import com.mj.jobapp.domain.user.User;
import com.mj.jobapp.factory.joboffer.JobOfferFactory;
import com.mj.jobapp.repository.joboffer.JobOfferRepository;
import com.mj.jobapp.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobOfferServiceImpl implements JobOfferService{

    private final JobOfferConverter converter;
    private final JobOfferRepository repository;
    private final UserRepository userRepository;
    private final JobOfferFactory factory;

    @Override
    public void createJobOffer(JobOfferDto dto) {
        Optional<User> foundUser = userRepository.findByName(dto.getUserName());
        try {
            User user = foundUser.orElseThrow(Exception::new);
            JobOffer jobOffer = factory.createJobOffer(dto, user);
            repository.save(jobOffer);
        } catch (Exception e) {
            log.error("User with name {}, not found", dto.getUserName());
        }
    }

    @Override
    public List<JobOfferDto> getValidOffersByFilters(String userName, String category) throws Exception{
        //TODO: add userName and category filter to select data
        List<JobOffer> validJobOffers = repository.findValidOffers();
        List<JobOfferDto> foundOffersDtos = new ArrayList<>();
        for (JobOffer validJobOffer : validJobOffers) {
            JobOfferDto jobOfferDto = converter.toDto(validJobOffer);
            foundOffersDtos.add(jobOfferDto);
        }
        return foundOffersDtos;
    }
}
