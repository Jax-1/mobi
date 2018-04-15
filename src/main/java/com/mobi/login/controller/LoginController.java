package com.mobi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobi.login.bean.UserAuthsBean;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class); 
	
	//µÇÂ¼ÇëÇó
	@RequestMapping("/login")
	private String login(UserAuthsBean userauths,ModelMap modelMap,HttpSession httpSession) {
		
		return null;
		
	}
}
