package ru.diti.coursework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.diti.coursework.entity.Deal;
import ru.diti.coursework.repository.api.DealRepository;
import ru.diti.coursework.service.api.DealService;

import java.util.List;

@Service
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;

    @Autowired
    public DealServiceImpl(DealRepository dealRepository) {
        this.dealRepository = dealRepository;
    }

    @Override
    public Deal findById(Long dealId) {
        return dealRepository.getOne(dealId);
    }

    @Override
    public List<Deal> getAllDeals() {
        return dealRepository.findAll();
    }

    @Override
    public void save(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void update(Deal deal) {
        dealRepository.save(deal);
    }

    @Override
    public void delete(Deal deal) {
        if (deal.getDealId() == null) {
            throw new RuntimeException("id = null");
        }
        dealRepository.deleteById(deal.getDealId());
    }
}
