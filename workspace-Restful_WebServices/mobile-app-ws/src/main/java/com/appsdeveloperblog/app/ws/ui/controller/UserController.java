package com.appsdeveloperblog.app.ws.ui.controller;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsdeveloperblog.app.ws.exception.UserServiceException;
import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.userservice.UserService;

@RestController
@RequestMapping("users")//http://8080/users
public class UserController {
	Map<String,UserRest> users;
	@Autowired
	UserService userService;
	@GetMapping(path = "/{userid}",
	produces =  {
			org.springframework.http.MediaType.APPLICATION_XML_VALUE,
			org.springframework.http.MediaType.APPLICATION_JSON_VALUE
			})
	public ResponseEntity<UserRest> getUser(@PathVariable String userid) {
		
		/*
		 * String sample=null; int samplelengh=sample.length(); if(true) throw new
		 * UserServiceException("A user service exception is thrown");
		 */	if(users.containsKey(userid))
		{
			
		return	new  ResponseEntity<UserRest>(users.get(userid),HttpStatus.OK); 
		}
		else {
			return	new  ResponseEntity<UserRest>(HttpStatus.NO_CONTENT); 
			
		}
	
	}
	@PostMapping(
			consumes = {
					org.springframework.http.MediaType.APPLICATION_XML_VALUE,
			org.springframework.http.MediaType.APPLICATION_JSON_VALUE
			},
			produces =  {
					org.springframework.http.MediaType.APPLICATION_XML_VALUE,
					org.springframework.http.MediaType.APPLICATION_JSON_VALUE
					}
			
			)
	
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails ) {
		
		UserRest  returnvalue =userService.createUser(userDetails);
		
		
		return new  ResponseEntity<UserRest>(returnvalue,HttpStatus.OK);
	}
	 
	@PutMapping(path = "/{userid}",
			consumes = {
					org.springframework.http.MediaType.APPLICATION_XML_VALUE,
			org.springframework.http.MediaType.APPLICATION_JSON_VALUE
			},
			produces =  {
					org.springframework.http.MediaType.APPLICATION_XML_VALUE,
					org.springframework.http.MediaType.APPLICATION_JSON_VALUE
					}
			)
	public ResponseEntity<UserRest> updateUser(@Valid @RequestBody UpdateUserDetailsRequestModel updateuserDetails,@PathVariable String userid) {
		
		UserRest storeuserdetails=users.get(userid);
		storeuserdetails.setFirstName(updateuserDetails.getFirstName());
		storeuserdetails.setLastName(updateuserDetails.getLastName());
		users.put(userid, storeuserdetails);
		return new ResponseEntity<UserRest>(storeuserdetails,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {
		
		users.remove(id);
		return ResponseEntity.noContent().build();
	}
	
}
