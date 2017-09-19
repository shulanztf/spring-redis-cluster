package com.hhcf.cache;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * @Title: RedisCacheConfig
 * @Description:redis 缓存组件
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:09:31
 * @Version:1.0
 */
//@Configuration
//@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

//	@Bean
//	public JedisConnectionFactory redisConnectionFactory() {
//		JedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory();
//
//		// Defaults
//		redisConnectionFactory.setHostName("192.168.1.166");
//		redisConnectionFactory.setPort(6379);
//		return redisConnectionFactory;
//	}
//
//	@Bean
//	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory cf) {
//		RedisTemplate<String, String> redisTemplate = new RedisTemplate<String, String>();
//		redisTemplate.setConnectionFactory(cf);
//		return redisTemplate;
//	}
//
//	@Bean
//	public CacheManager cacheManager(RedisTemplate redisTemplate) {
//		RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
//		cacheManager.setDefaultExpiration(3000);
//		return cacheManager;
//	}

}
