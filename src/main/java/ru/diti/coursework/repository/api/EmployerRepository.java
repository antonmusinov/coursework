package ru.diti.coursework.repository.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.diti.coursework.entity.Employer;

@Repository
public interface EmployerRepository extends CrudRepository<Employer, Long> {
}
