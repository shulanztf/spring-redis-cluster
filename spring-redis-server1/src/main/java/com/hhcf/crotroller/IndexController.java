package com.hhcf.crotroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hhcf.entity.UserEntity;

/**
 * 
 * @Title: IndexController
 * @Description:
 * @see http://www.cnblogs.com/andyfengzp/p/6434287.html
 * @Author: zhaotf
 * @Since:2017年9月19日 上午10:01:28
 * @Version:1.0
 */
@Controller
@RequestMapping("/index")
public class IndexController {
	private final Gson gson = new GsonBuilder().setDateFormat("yyyyMMddHHmmss").create();

	@RequestMapping(value = "login")
	public String login(HttpServletRequest request, String username) {
		request.getSession().setAttribute("user", gson.toJson(new UserEntity(username, "123456")));

		return "login";
	}

	@RequestMapping(value = "index")
	public String index(HttpServletRequest request, Model model) {
//		User user = gson.fromJson(request.getSession().getAttribute("user").toString(), User.class);
//		model.addAttribute("user", user);


		return "index";
	}
}
