package ru.diti.coursework.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.diti.coursework.entity.Deal;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {
}
