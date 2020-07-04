package ru.diti.coursework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diti.coursework.entity.Employer;
import ru.diti.coursework.repository.api.EmployerRepository;
import ru.diti.coursework.service.api.EmployerService;

import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public Employer findById(Long employerId) {
        return employerRepository.getOne(employerId);
    }

    @Override
    public List<Employer> getAllEmployer() {
        return employerRepository.findAll();
    }

    @Override
    public void save(Employer employer) {
        employerRepository.save(employer);
    }

    @Override
    public void update(Employer employer) {
        employerRepository.save(employer);
    }

    @Override
    public void delete(Employer employer) {
        employerRepository.delete(employer);
    }
}
