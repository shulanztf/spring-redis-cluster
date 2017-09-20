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
 * @Description:Spring-Session+Redis实现session共享 redis3.2.6
 * @see http://www.cnblogs.com/qlong8807/p/5557271.html 以此为主
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
		logger.info("登录用户sessionId:" + request.getSession().getId() + "," + username);
		// request.getSession().setAttribute("user", gson.toJson(new
		// UserEntity(username, "123456")));
		request.getSession().setAttribute(username, request.getSession().getId() + "123456");
		return "login";
	}

	@ResponseBody
	@RequestMapping(value = "index")
	public Object index(HttpServletRequest request, String username) {
		logger.info("校验用户sessionId:" + request.getSession().getId() + "," + username);
		String jsonStr = (String) request.getSession().getAttribute(username);
		Map<String, Object> map = new HashMap<>();
		map.put("user", jsonStr);
		return map;
	}

}
