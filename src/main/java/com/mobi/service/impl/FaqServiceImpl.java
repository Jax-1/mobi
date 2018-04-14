package com.mobi.service.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobi.bean.Faq;
import com.mobi.canstants.Canstants;
import com.mobi.dao.FaqMapper;
import com.mobi.servic.IFaqService;

@Service("faqService")
public class FaqServiceImpl implements IFaqService {
	
	@Autowired
	 private FaqMapper faqMapper;
	
	public String insertFaq(Faq faq) {
		if(null !=faqMapper.selectByPhenomenon(faq.getPhenomenon())){
			return Canstants.faqExist;
		}
		int i=faqMapper.insertSelective(faq);
		if(i != -1){
			return Canstants.faqEditSuccess;
		}
		return Canstants.faqEditFail;
	}
 
	

}
