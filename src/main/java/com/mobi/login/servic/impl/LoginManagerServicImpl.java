package com.mobi.login.servic.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.mobi.login.bean.UserAuthsBean;
import com.mobi.login.dao.UserAuthsMapper;
import com.mobi.login.servic.LoginManagerServic;
import com.mobi.util.Validate;



public class LoginManagerServicImpl implements LoginManagerServic {
	
	@Resource
	private UserAuthsMapper userAuthsMapper;
	@Override
	public boolean checkLoginInfo(UserAuthsBean userauths, HttpSession httpSession) {
		if(!Validate.notNull(userauths.getIdentifier())||!Validate.notNull(userauths.getCredential())) {
			return false;
		}
		String psd = this.userAuthsMapper.getPwdByUserName(userauths.getIdentifier());
		if(Validate.notNull(psd)&&psd.equals(userauths.getCredential())) {
			return true;
		}
		return false;
	}


}
