package com.mobi.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mobi.login.bean.UserAuthsBean;
import com.mobi.login.dao.UserAuthsMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	private static Logger logger = Logger.getLogger(LoginController.class); 
//	@Resource
	//private UserAuthsMapper userAuthsMapper;
	//µÇÂ¼ÇëÇó
	@RequestMapping("/login")
	private String login(UserAuthsBean userauths,ModelMap modelMap,HttpSession httpSession) {
		System.out.println(userauths.getIdentifier()+"    "+userauths.getCredential());
//		String passwordByUserName = this.userAuthsMapper.getPasswordByUserName(userauths.getIdentifier());
//		System.out.println("psd"+passwordByUserName);
		return "redirect:/login/loginHtml";
		
	}
}
