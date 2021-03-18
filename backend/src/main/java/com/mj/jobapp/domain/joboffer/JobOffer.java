package com.mj.jobapp.domain.joboffer;

import javax.persistence.*;
import java.util.Date;

import com.mj.jobapp.domain.user.User;
import lombok.Data;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
public class JobOffer {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Column(name = "CATEGORY")
    private JobOfferCategory category;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    private Date endDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NAME", referencedColumnName="NAME")
    private User user;
}
