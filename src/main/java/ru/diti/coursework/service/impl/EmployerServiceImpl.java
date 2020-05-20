package ru.diti.coursework.service.impl;

import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diti.coursework.entity.Employer;
import ru.diti.coursework.repository.api.EmployerRepository;
import ru.diti.coursework.service.api.EmployerService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerServiceImpl(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    @Override
    public List<Employer> getAllEmployer() {
        return (List<Employer>) employerRepository.findAll();
    }
}
