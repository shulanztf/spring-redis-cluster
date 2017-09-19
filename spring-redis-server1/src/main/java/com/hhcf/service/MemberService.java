package com.hhcf.service;

import com.hhcf.entity.Member;

/**
 * 
 * @Title: MemberService
 * @Description:
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:23:16
 * @Version:1.0
 */
public interface MemberService {

	public void add(final String id);

	public void delete(String id);

	public Member get(String id);

}
