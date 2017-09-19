package com.hhcf.crotroller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hhcf.entity.UserEntity;

/**
 * 
 * @Title: IndexController
 * @Description:Spring-Session+Redis实现session共享
 * @see http://www.cnblogs.com/andyfengzp/p/6434287.html
 * @Author: zhaotf
 * @Since:2017年9月19日 上午10:01:28
 * @Version:1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	Logger logger = Logger.getLogger(IndexController.class);
	private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();

	/**
	 * http://localhost:8080/spring-redis-server1/index/login.do
	 * 
	 * @param request
	 * @param username
	 * @return String
	 */
	@RequestMapping("login")
	@ResponseBody
	public String login(HttpServletRequest request, String username) {
		logger.info("登录用户:" + username);
		request.getSession().setAttribute("user", gson.toJson(new UserEntity(username, "123456")));
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "index")
	public Object index(HttpServletRequest request, Model model) {
		UserEntity user = gson.fromJson(request.getSession().getAttribute("user").toString(), UserEntity.class);
		// logger.info("登录用户:" + username);
		Map<String, Object> map = new HashMap<>();
		map.put("user", user);
		return map;
	}

}
