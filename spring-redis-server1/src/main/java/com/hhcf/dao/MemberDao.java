package com.hhcf.dao;

import java.util.List;

import com.hhcf.entity.Member;

/**
 * 
 * @Title: MemberDao
 * @Description:
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:19:17
 * @Version:1.0
 */
public interface MemberDao {

	public boolean add(String id);

	public abstract boolean add(List<Member> list);

	public void delete(String key);

	public Member get(String keyId);

}
