package com.chinesedreamer.easycoding.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesedreamer.easycoding.sys.user.service.UserService;
import com.chinesedreamer.easycoding.util.MessageUtil;
import com.chinesedreamer.easycoding.web.vo.ResponseVo;

/**
 * Description: 用户注册等页面
 * Auth:Paris
 * Date:Jan 12, 2017
**/
@Controller
@RequestMapping(value="register")
public class RegisterController {
	
	@Resource
	private UserService userService;
	
	/**
	 * 进入注册页面
	 * @return
	 */
	@RequestMapping(value="",method=RequestMethod.GET)
	public String registerMain(){
		return "register/main";
	}
	
	/**
	 * 检查用户是否存在
	 * @param username
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="exist", method = {RequestMethod.GET,RequestMethod.POST})
	public ResponseVo checkUserExist(@RequestParam(value="username")String username){
		boolean exist = this.userService.exist(username);
		if (exist) {
			return MessageUtil.failure();
		}else {
			return MessageUtil.success();
		}
	}
	
	/**
	 * 提交注册申请
	 * @param username
	 * @param password
	 * @param company
	 * @param model
	 * @return
	 */
	@RequestMapping(value="apply", method=RequestMethod.POST)
	public String registerApply(
			@RequestParam(value="username")String username,
			@RequestParam(value="password")String password,
			@RequestParam(value="company")String company,
			Model model
			){
		return null;
	}
}
