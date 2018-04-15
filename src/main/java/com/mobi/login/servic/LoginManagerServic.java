package com.mobi.login.servic;

import javax.servlet.http.HttpSession;


import com.mobi.login.bean.UserAuthsBean;


public interface LoginManagerServic {
	public boolean checkLoginInfo(UserAuthsBean userauths,HttpSession httpSession);


}
