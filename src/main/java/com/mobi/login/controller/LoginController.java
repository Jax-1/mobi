package com.mobi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobi.login.bean.UserAuthsBean;
import com.mobi.login.servic.LoginManagerServic;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class); 
	@Resource
	private LoginManagerServic loginManager;
	//登录请求
	@RequestMapping("/login")
	private String login(UserAuthsBean userauths,ModelMap modelMap,HttpSession httpSession) {
		boolean checkLoginInfo = this.loginManager.checkLoginInfo(userauths, httpSession);
		if(checkLoginInfo) {
			//跳转到主页面
			return "login";
		}
		
		return "redirect:/login/loginHtml";
		
	}
	@RequestMapping("/loginHtml")
	private String loginHtml() {
		return "login";
		
	}
}
