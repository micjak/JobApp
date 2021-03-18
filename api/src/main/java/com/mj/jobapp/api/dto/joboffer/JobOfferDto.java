package com.mj.jobapp.api.dto.joboffer;

import java.io.Serializable;
import java.time.Instant;

import lombok.Data;

@Data
public class JobOfferDto implements Serializable {

    private static final long serialVersionUID = 4941416776362775423L;

    //TODO: should be enum instead of String
    private String category;
    private Instant startDate;
    private Instant endDate;
    private String userName;
}
