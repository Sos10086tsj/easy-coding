package com.chinesedreamer.easycoding.web.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinesedreamer.easycoding.util.MessageUtil;
import com.chinesedreamer.easycoding.web.vo.ResponseVo;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * Description:
 * Auth:Paris
 * Date:Jan 12, 2017
**/
@Controller
@RequestMapping(value="captcha")
public class KaptchaController {
	private Logger logger = LoggerFactory.getLogger(KaptchaController.class);
	
	@Autowired
	private Producer producer;

	@RequestMapping(value="")
	public void getCaptchaImage(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		String capText = producer.createText();
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		BufferedImage bi = producer.createImage(capText);
		ServletOutputStream out = null;
		try {
			out = response.getOutputStream();
			ImageIO.write(bi, "jpg", out);
			out.flush();
		} catch (Exception e) {
			logger.error("{}",e);
		}finally {
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
					logger.error("{}",e);
				}
			}
		}
	}
	
	@ResponseBody
	@RequestMapping(value="validate")
	public ResponseVo validate(HttpServletRequest request,@RequestParam(value="code")String code){
		HttpSession session = request.getSession();
		String sessionCode = (String)session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if (null == sessionCode || !sessionCode.equals(code)) {
			return MessageUtil.failure();
		}else {
			return MessageUtil.success();
		}
	}
}
