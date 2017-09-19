package com.hhcf.entity;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * 
 * @Title: Member
 * @Description:
 * @Author: zhaotf
 * @Since:2017年3月6日 下午4:19:59
 * @Version:1.0
 */
@SuppressWarnings("serial")
public class Member implements Serializable {
	private String id;
	private String nickname;

	public Member() {
	}

	public Member(String id, String nickname) {
		this.setId(id);
		this.setNickname(nickname);
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}
