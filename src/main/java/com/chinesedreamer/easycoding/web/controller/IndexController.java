package com.chinesedreamer.easycoding.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinesedreamer.easycoding.sys.user.service.UserService;

/**
 * Description:
 * Auth:Paris
 * Date:Nov 15, 2016
**/
@Controller
public class IndexController {
	
	private Logger logger = LoggerFactory.getLogger("EC");
	
	@Resource
	private UserService userService;
	
	/**
	 * 系统首页
	 * @return
	 */
	@RequestMapping(value = {"","login"} , method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	/**
	 * 用户登陆
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login" , method = RequestMethod.POST)
	public String submitLogin(@RequestParam(value="username")String username, @RequestParam(value="password")String password, Model model, HttpServletRequest request){
		try {
			this.userService.userLogin(username, password);
			return "redirect:/index";
		} catch (Exception e) {
			this.logger.error("{}",e);
			model.addAttribute("errorMessage", "用户名或者密码错误");
			return "login";
		}
	}
	
	/**
	 * 进入系统首页
	 * @return
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(){
		return "index";
	}
}
