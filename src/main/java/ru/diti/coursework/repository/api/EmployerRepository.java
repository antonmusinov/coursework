package ru.diti.coursework.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diti.coursework.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
}
