package ru.diti.coursework.service.api;

import org.springframework.stereotype.Service;
import ru.diti.coursework.entity.Deal;

import java.util.Collection;
import java.util.List;

public interface DealService {
    Deal findById(Long dealId);
    List<Deal> getAllDeals();
    void save(Deal deal);
    void update(Deal deal);
    void delete(Deal deal);
}
