package com.payement.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payement.demo.dao.PayementDAO;

@Service
public class PayementServiceImpl implements PayementService {

	@Autowired
	PayementDAO dao;

	public PayementDAO getDao() {
		return dao;
	}

	public void setDao(PayementDAO dao) {
		this.dao = dao;
	}
	
	
}
