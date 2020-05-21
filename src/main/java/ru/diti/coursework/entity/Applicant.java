package ru.diti.coursework.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "applicants")
@Data
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long applicantId;

    private String firstName;
    private String lastName;
    private String middleName;

    /**
     * Квалификация
     */
    private Integer experience;

    /**
     * Вид деятельности
     */
    private String activities;

    /**
     * О себе
     */
    private String additionalInformation;

    /**
     * ЗП
     */
    private BigDecimal salary;

}
