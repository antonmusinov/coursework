package ru.diti.coursework.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "deals")
@Data
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employerId")
    private Employer employer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "applicantId")
    private Applicant applicant;

    /**
     * Должность
     */
    private String position;

    /**
     * Комиссионные
     */
    private BigDecimal commissionCharge;
}
