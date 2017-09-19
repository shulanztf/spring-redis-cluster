package com.hhcf.crotroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hhcf.dao.impl.MemberDaoImpl;
import com.hhcf.service.CommonService;
import com.hhcf.service.MemberService;

/**
 * 
 * @ClassName: ConsumerCrotroller
 * @Description:
 * @author: zhaotf
 * @date: 2017年2月19日 下午2:34:30
 */
@Controller
@RequestMapping("/consumer")
public class ConsumerCrotroller {
	private static Logger logger = Logger.getLogger(ConsumerCrotroller.class);

	@Autowired
	private MemberService memberService;
	@Autowired
	private CommonService commonService;

	@RequestMapping("/getMember")
	@ResponseBody
	public Object getMember(String id) {
		return memberService.get(id);
	}

	@RequestMapping("/deleteMember")
	@ResponseBody
	public Object deleteMember(String id) {
		memberService.delete(id);
		return "deleteMember成功";
	}

	@RequestMapping("/addMember")
	@ResponseBody
	public Object addMember(String id) {
		logger.info("控制端接收参数:" + id);
		memberService.add(id);
		return "addMember成功";
	}

	/**
	 * 通过kafka改善消息
	 * 
	 * @return Object
	 */
	@RequestMapping("/sndMesForTemplate")
	@ResponseBody
	public Object sndMesForTemplate() {
		return commonService.provinceCities("");
	}

}
