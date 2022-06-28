package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cory.rice.bingetv.dto.UserDto;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.mappers.UserMapper;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.repository.UserRepository;
import org.cory.rice.bingetv.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	VerificationTokenRepository vTokenRepo;
	
	//get a list of all users by using MapStruct mappers to map the model to dto
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream()
				.map(userMapper::modelToDto)
				.collect(toList());
	}
	
	public UserDto getUserById(Long userId) {//find user by userId
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		return userMapper.modelToDto(user);
	}
	
	public User updateUser(Long userId, User userDetails) {//updates user and checks to see if
		User updatedUser = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		if (userDetails.getPassword() != null || userDetails.getPassword() != "") {//check to seee if form has password to update
			String encoded = new BCryptPasswordEncoder().encode(userDetails.getPassword());
			updatedUser.setPassword(encoded);//rehashes newpassword
		}
		if (userDetails.getBio() != null || userDetails.getBio() != "") {
			updatedUser.setBio(userDetails.getBio());//checks to see if bio was updated
		}
		return userRepository.save(updatedUser);//saves user
	}
	
	public void deleteUser(Long userId) {//deletes user by id
		User deletedUser = userRepository.findById(userId)
				.orElseThrow(() -> new BingeTvException("No Users found with ID : "
						+ userId));
		var removedToken = vTokenRepo.findByUser(deletedUser);
		vTokenRepo.delete(removedToken.get());//deletes verificationToken before user since OneToOne is unidirectional on token
		userRepository.delete(deletedUser);//delete user after token
	}
	
	public Optional<User> getUserByUsername(String username) {//searches user by username
		Optional<User> user = userRepository.findByUsername(username);
		return user;
	}
	
}
