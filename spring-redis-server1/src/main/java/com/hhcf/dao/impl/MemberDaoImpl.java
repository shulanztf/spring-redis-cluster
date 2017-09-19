package com.hhcf.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.hhcf.dao.MemberDao;
import com.hhcf.entity.Member;

/**
 * 
 * @Title: MemberDaoImpl
 * @Description:
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:18:52
 * @Version:1.0
 */
@Repository("memberDao")
public class MemberDaoImpl implements MemberDao {
	private static Logger logger = Logger.getLogger(MemberDaoImpl.class);
	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	// /**
	// * 设置redisTemplate
	// *
	// * @param redisTemplate
	// * the redisTemplate to set
	// */
	// public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
	// this.redisTemplate = redisTemplate;
	// }

	/**
	 * 获取 RedisSerializer <br>
	 * ------------------------------<br>
	 */
	protected RedisSerializer<String> getRedisSerializer() {
		return stringRedisTemplate.getStringSerializer();
	}

	/**
	 * 添加对象
	 */
	@Override
	public boolean add(final String id) {
		logger.info("执行结果11-" + id + ":" + stringRedisTemplate.opsForValue().get(id));
		stringRedisTemplate.opsForValue().set(id, id + "aa中方a");
		logger.info("执行结果22-" + id + ":" + stringRedisTemplate.opsForValue().get(id));

		// boolean result = stringRedisTemplate.execute(new
		// RedisCallback<Boolean>() {
		// public Boolean doInRedis(RedisConnection connection) throws
		// DataAccessException {
		// RedisSerializer<String> serializer = getRedisSerializer();
		// byte[] key = serializer.serialize(id);
		// byte[] name = serializer.serialize(id + "昵称");
		// return connection.setNX(key, name);
		// }
		// });
		return false;
	}

	/**
	 * 添加集合
	 */
	@Override
	public boolean add(final List<Member> list) {
		Assert.notEmpty(list);
		boolean result = stringRedisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				for (Member member : list) {
					byte[] key = serializer.serialize(member.getId());
					byte[] name = serializer.serialize(member.getNickname());
					connection.setNX(key, name);
				}
				return true;
			}
		}, false, true);
		return result;
	}

	/**
	 * 删除对象 ,依赖key
	 */
	@Override
	public void delete(String key) {
		List<String> list = new ArrayList<String>();
		list.add(key);
		delete(list);
		stringRedisTemplate.delete(key);
	}

	/**
	 * 删除集合 ,依赖key集合
	 */
	public void delete(List<String> keys) {
		for (String key : keys) {
			stringRedisTemplate.delete(key);
		}
	}

	/**
	 * 修改对象
	 */
	public boolean update(final Member member) {
		String key = member.getId();
		if (get(key) == null) {
			throw new NullPointerException("数据行不存在, key = " + key);
		}
		boolean result = stringRedisTemplate.execute(new RedisCallback<Boolean>() {
			public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(member.getId());
				byte[] name = serializer.serialize(member.getNickname());
				connection.set(key, name);
				return true;
			}
		});
		return result;
	}

	/**
	 * 根据key获取对象
	 */
	@Override
	public Member get(final String keyId) {
		Member result = stringRedisTemplate.execute(new RedisCallback<Member>() {
			public Member doInRedis(RedisConnection connection) throws DataAccessException {
				RedisSerializer<String> serializer = getRedisSerializer();
				byte[] key = serializer.serialize(keyId);
				byte[] value = connection.get(key);
				if (value == null) {
					return null;
				}
				String nickname = serializer.deserialize(value);
				return new Member(keyId, nickname);
			}
		});
		return result;
	}

}
