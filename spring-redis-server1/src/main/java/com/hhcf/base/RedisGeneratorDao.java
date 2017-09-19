package com.hhcf.base;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * 
 * @Title: RedisGeneratorDao
 * @Description:基类DAO
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:16:39
 * @Version:1.0
 */
public class RedisGeneratorDao<K extends Serializable, V extends Serializable> {
//	@Autowired
//	protected RedisTemplate<K, V> redisTemplate;
//
//	/**
//	 * 设置redisTemplate
//	 *
//	 * @param redisTemplate
//	 *            the redisTemplate to set
//	 */
//	public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
//		this.redisTemplate = redisTemplate;
//	}
//
//	/**
//	 * 获取 RedisSerializer <br>
//	 * ------------------------------<br>
//	 */
//	protected RedisSerializer<String> getRedisSerializer() {
//		return redisTemplate.getStringSerializer();
//	}

}
