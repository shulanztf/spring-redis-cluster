package com.hhcf.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hhcf.dao.MemberDao;
import com.hhcf.entity.Member;
import com.hhcf.service.MemberService;

/**
 * 
 * @Title: MemberServiceImpl
 * @Description:
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:24:39
 * @Version:1.0
 */
@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDao memberDao;

	@Override
	public void add(String id) {
		memberDao.add(id);
	}

	@Override
	public void delete(String id) {
		memberDao.delete(id);
	}

	@Override
	public Member get(String id) {
		return memberDao.get(id);
	}

}
