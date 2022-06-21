package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cory.rice.bingetv.config.SecurityConfig;
import org.cory.rice.bingetv.dto.ShowsDto;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.mappers.UserMapper;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@NoArgsConstructor
@Transactional
@Slf4j
public class ProfileService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	UserMapper userMapper;
	
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream()
				.map(userMapper::modelToDto)
				.collect(toList());
	}
	
	public UserDto getUserById(Long userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		
		return userMapper.modelToDto(user);
	}
	
	public User updateUser(Long userId, User userDetails) {
		User updatedUser = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		String encoded = new BCryptPasswordEncoder().encode(userDetails.getPassword());
		updatedUser.setPassword(encoded);
		
		return  userRepository.save(updatedUser);
	}
	
	public void deleteUser(Long userId) {
		User deletedUser = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		
		userRepository.delete(deletedUser);
	}
}
