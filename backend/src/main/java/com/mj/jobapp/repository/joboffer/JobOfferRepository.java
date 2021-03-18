package com.mj.jobapp.repository.joboffer;

import java.util.List;

import com.mj.jobapp.domain.joboffer.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobOfferRepository extends JpaRepository<JobOffer, Long> {

    @Query("SELECT o FROM JobOffer o where o.startDate >= current_date and o.endDate >= current_date ")
    List<JobOffer> findValidOffers();

}
