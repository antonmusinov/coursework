package ru.diti.coursework.service.api;

import ru.diti.coursework.entity.Employer;

import java.util.List;

public interface EmployerService {
    Employer findById(Long employerId);
    List<Employer> getAllEmployer();
    void save(Employer employer);
    void update(Employer employer);
    void delete(Employer employer);
}
