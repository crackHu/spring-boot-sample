package com.senior.sample.service;

import com.senior.sample.domain.Travelrecord;
import com.senior.sample.repository.TravelrecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TravelrecordService {

    @Autowired
    private TravelrecordRepository repository;

    @Transactional(propagation = Propagation.REQUIRED)
    public Travelrecord save(Travelrecord salesman) {
        return repository.save(salesman);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Travelrecord> findAll() {
        return repository.findAll();
    }
}