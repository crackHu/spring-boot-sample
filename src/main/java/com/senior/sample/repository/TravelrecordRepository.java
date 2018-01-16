package com.senior.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.senior.sample.domain.Travelrecord;

public interface TravelrecordRepository extends JpaRepository<Travelrecord, Long> {
	
	Travelrecord save(Travelrecord salesman);

	@Query(value = "select * from travelrecord limit 0,18", nativeQuery = true)
	List<Travelrecord> findAll();
}