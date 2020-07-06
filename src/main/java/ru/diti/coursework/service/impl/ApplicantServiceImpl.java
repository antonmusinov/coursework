package ru.diti.coursework.service.impl;

import org.apache.commons.lang3.ObjectUtils;
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

    @Override
    public Applicant findById(Long applicantId) {
        return applicantRepository.getOne(applicantId);
    }

    @Override
    public void save(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    @Override
    public void update(Applicant applicant) {
        applicantRepository.save(applicant);
    }

    @Override
    public void delete(Applicant applicant) {
        if (applicant.getApplicantId() == null) {
            throw new RuntimeException("id = null");
        }
        final Applicant deleteApplicant = applicantRepository.getOne(applicant.getApplicantId());
        if (ObjectUtils.equals(applicant.getApplicantId(), deleteApplicant.getApplicantId())) {
            applicantRepository.delete(applicant);
        }
    }
}
