package com.hhcf.entity;

import java.io.Serializable;

/**
 * 
 * @Title: UserEntity
 * @Description:
 * @Author: zhaotf
 * @Since:2017年9月19日 上午10:14:00
 * @Version:1.0
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 4665175924748661132L;
	private String username;
	private String pwd;

	public UserEntity(String username, String pwd) {
		this.username = username;
		this.pwd = pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
