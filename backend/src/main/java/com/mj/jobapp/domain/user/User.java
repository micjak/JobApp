package com.mj.jobapp.domain.user;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = -5078524064025211675L;

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Column(name = "NAME", unique = true)
    private String name;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ACCOUNT_CREATE_DATE")
    private Date accountCreateDate;

}
