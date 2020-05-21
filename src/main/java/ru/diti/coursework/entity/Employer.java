package ru.diti.coursework.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employers")
@Data
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employerId;

    /**
     * Название компании
     */
    @Column(name = "employer_name")
    private String employerName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;


}
