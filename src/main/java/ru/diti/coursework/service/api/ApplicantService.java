package ru.diti.coursework.service.api;

import ru.diti.coursework.entity.Applicant;

import java.util.List;

public interface ApplicantService {
    List<Applicant> allApplicants();
    Applicant findById(Long applicantId);
    void save(Applicant applicant);
    void update(Applicant applicant);
    void delete(Applicant applicant);
}
