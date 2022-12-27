package com.appsdeveloperblog.photoapp.api.users.service;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.photoapp.api.users.data.UserEntity;
import com.appsdeveloperblog.photoapp.api.users.data.UsersRepository;
import com.appsdeveloperblog.photoapp.api.users.shared.UserDto;

@Service("userService")
public class UsersServiceImpl implements UsersService {

	UsersRepository usersRepository;
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UsersServiceImpl(UsersRepository usersRepository,BCryptPasswordEncoder bCryptPasswordEncoder) {

		this.usersRepository = usersRepository;
			this.bCryptPasswordEncoder=bCryptPasswordEncoder;
	}

	@Override
	public UserDto createUser(UserDto userDetails) {
		// TODO Auto-generated method stub

		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		//userEntity.setEncryptedPassword("test");
		usersRepository.save(userEntity);

		UserDto returnValue=modelMapper.map(userEntity, UserDto.class);
		return returnValue;
	}

	
	  @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        UserEntity userEntity = usersRepository.findByEmail(email);
	        if (userEntity == null)
	            throw new UsernameNotFoundException(email);
	 
	        return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), new ArrayList<>());
	    }

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		// TODO Auto-generated method stub
UserEntity userEntity = usersRepository.findByEmail(email);
		
		if(userEntity == null) throw new UsernameNotFoundException(email);
		
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}
}
