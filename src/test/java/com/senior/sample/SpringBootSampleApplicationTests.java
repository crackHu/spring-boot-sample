package com.senior.sample;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.test.context.junit4.SpringRunner;

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

}
