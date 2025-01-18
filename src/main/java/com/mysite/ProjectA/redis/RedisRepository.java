package com.mysite.ProjectA.redis;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisRepository {
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	
	
	public void save(String key, String value) {	
		redisTemplate.opsForValue().set(key, value);
	}
	
	public String findByKey(String key) {
		return redisTemplate.opsForValue().get(key);
	}
	public void delete(String key) {
		redisTemplate.delete(key);
	}
	public Set<String> findAll() {
		return redisTemplate.keys("*");
	}
	
}
