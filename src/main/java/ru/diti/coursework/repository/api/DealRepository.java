package ru.diti.coursework.repository.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.diti.coursework.entity.Deal;

@Repository
public interface DealRepository extends CrudRepository<Deal, Long> {
}
