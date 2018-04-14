package com.mobi.servic;

import javax.servlet.http.HttpSession;

import com.mobi.bean.Person;


public interface IPersonService {
	public String registerPerson(Person person);
	
	public String loginPerson(Person person,HttpSession httpSession);

	public boolean activatEmail(Person person);

	
}
