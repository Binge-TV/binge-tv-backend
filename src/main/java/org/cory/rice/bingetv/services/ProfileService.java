package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.mappers.UserMapper;
import org.cory.rice.bingetv.models.Users;
import org.cory.rice.bingetv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
	
	//get a list of all users by using MapStruct mappers to map the model to dto
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream()
				.map(userMapper::modelToDto)
				.collect(toList());
	}
	
	public UserDto getUserById(Long userId) {//find user by userId
		Users users = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		return userMapper.modelToDto(users);
	}
	
	public Users updateUser(Long userId, Users usersDetails) {//updates user and checks to see if
		Users updatedUsers = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		if (usersDetails.getBio() != null || usersDetails.getBio() != "") {
			updatedUsers.setBio(usersDetails.getBio());//checks to see if bio was updated
		}
		return userRepository.save(updatedUsers);//saves user
	}
	
	public void deleteUser(Long userId) {//deletes user by id
		Users deletedUsers = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		userRepository.delete(deletedUsers);//delete user after token
	}
	
	public Optional<Users> getUserByUsername(String username) {//searches user by username
		Optional<Users> user = userRepository.findByUsername(username);
		return user;
	}
	
}
