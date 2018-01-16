package com.senior.sample;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.senior.sample.domain.Travelrecord;
import com.senior.sample.service.TravelrecordService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SalesmanServiceTest {
	@Autowired
	private TravelrecordService service;

	@Test
	public void testFindAll() {
		service.findAll().forEach(salesman -> System.out.println(salesman.toString()));
	}

	@Test
	public void testSave() {
		Travelrecord salesman = new Travelrecord();
		salesman.setName("电风扇");
		salesman.setPhone("3333333");
		service.save(salesman);
	}
}