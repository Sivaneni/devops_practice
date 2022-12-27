package com.appsdeveloperblog.photoapp.api.users.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;

public interface UsersService extends UserDetailsService{
UserDto createUser(UserDto userDetails);
UserDto getUserDetailsByEmail(String email);
UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;
}
