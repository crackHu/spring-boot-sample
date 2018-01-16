package com.senior.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.senior.sample.domain.Travelrecord;
import com.senior.sample.repository.TravelrecordRepository;

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