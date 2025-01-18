package com.mysite.ProjectA.redis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

	@Autowired
	private RedisRepository redisRepository;

	@PostMapping("/save")
	public String save(@RequestBody Map<String, String> data) {
		String key = data.get("key");
		String value = data.get("value");
		redisRepository.save(key, value);
		return "메모리에 저장 성공";
	}

	@GetMapping("/list")
	public List<Map<String, String>> getList() {
		Set<String> keys = redisRepository.findAll();
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		for (String key : keys) {
			Map<String, String> entry = new HashMap<String, String>();
			entry.put("key", key);
			entry.put("value", redisRepository.findByKey(key)); // value를 가져오기 위해 findByKey 호출
			result.add(entry);
		}
		return result;
	}

	@DeleteMapping("/delete/{key}")
	public String delete(@PathVariable(value = "key") String key) {
		redisRepository.delete(key);
		return "삭제 성공";
	}

}
