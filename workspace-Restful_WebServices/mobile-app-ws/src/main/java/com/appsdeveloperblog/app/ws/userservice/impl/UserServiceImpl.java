package com.appsdeveloperblog.app.ws.userservice.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.app.ws.shared.Utils;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;
@Service
public class UserServiceImpl implements UserService {
	Map<String,UserRest> users;
	Utils utils;
	@Autowired
	public UserServiceImpl(Utils utils) {
		
		this.utils=utils;
	}
	
	@Override
	public UserRest createUser(UserDetailsRequestModel userDetails) {
		// TODO Auto-generated method stub
		UserRest returnvalue=new UserRest();
		returnvalue.setEmail(userDetails.getEmail());
		
		String Userid=utils.generateuserid();
		returnvalue.setUserid(Userid);
		if(users==null) users=new HashMap<>();
		users.put(Userid, returnvalue);
		
		return returnvalue;
	}

}
