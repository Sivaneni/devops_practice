package com.appsdeveloperblog.app.ws.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;
@Service
public class Utils {

	public String generateuserid() {
		
		
		return UUID.randomUUID().toString();
	}
	
}
