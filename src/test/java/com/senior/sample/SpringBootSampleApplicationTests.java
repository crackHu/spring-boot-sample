package com.senior.sample;

import java.io.Serializable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootSampleApplicationTests {

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	public void opsForValue() {
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("opsForValue", "opsForValue");
	}
	
	@Test
	public void opsForList() {
		ListOperations<String, String> opsForList = redisTemplate.opsForList();
		opsForList.rightPush("opsForList", "opsForList");
	}
	
	@Test
	public void opsForSet() {
		SetOperations opsForSet = redisTemplate.opsForSet();
		opsForSet.add("opsForSet", "opsForSet");
	}
	
	@Test
	public void opsForZSet() {
		ZSetOperations opsForZSet = redisTemplate.opsForZSet();
		opsForZSet.add("opsForZSet", "opsForZSet", 1);
	}
	
	@Test
	public void opsForHash() {
		HashOperations opsForHash = redisTemplate.opsForHash();
		opsForHash.put("opsForHash", "opsForHashK", "opsForHashV");
	}
	
	@Test
	public void opsForOther() {
		redisTemplate.opsForCluster();
		GeoOperations opsForGeo = redisTemplate.opsForGeo();
		redisTemplate.opsForHyperLogLog();
	}
	
	@Test
	public void testGet() {
		ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		operations.set("test", new User("email", "username", "password"));
        Object result = operations.get("test");
        if (result instanceof User) {
            System.out.println(result);
        }
	}
	
	@Test
	public void testRest() {
		String mpSendTmplUrl = "http://127.0.0.1:8080/PM-server/pcpatient/pc_patientList";
		User user = new User("touser", "templateId", "data");
		RestTemplate restTemplate = new RestTemplate();
		User response = restTemplate.postForObject(mpSendTmplUrl, user, User.class);
		System.out.println(response);
	}

}
