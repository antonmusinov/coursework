package ru.diti.coursework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diti.coursework.entity.Applicant;
import ru.diti.coursework.repository.api.ApplicantRepository;
import ru.diti.coursework.service.api.ApplicantService;

import java.util.List;

@Service
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    @Override
    public List<Applicant> allApplicants() {
        return applicantRepository.findAll();
    }
}
