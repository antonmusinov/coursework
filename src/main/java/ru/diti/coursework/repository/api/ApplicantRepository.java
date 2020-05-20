package ru.diti.coursework.repository.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.diti.coursework.entity.Applicant;

@Repository
public interface ApplicantRepository extends CrudRepository<Applicant, Long> {
}
