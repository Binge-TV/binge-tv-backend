package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cory.rice.bingetv.dto.ShowsDto;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.mappers.ShowMapper;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.models.User;
import org.cory.rice.bingetv.repository.ShowRepository;
import org.cory.rice.bingetv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
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
public class ShowService {
	@Autowired
	private  ShowRepository showRepository;
	@Autowired
	UserDetailsServiceImpl userDetailsService;
	@Autowired
	private ShowMapper showMapper;
	


	@Autowired
	private AuthService authService;
	@Autowired
	private UserRepository userRepository;
	
//	public ShowsDto saveShow(ShowsDto showsDto, UserDto userDto) {
//		Shows save = showRepository.save(showMapper.dtoToModel(showsDto));
//		User user = userRepository.findById(userDto.getUserId())
//				.orElseThrow(() -> new BingeTvException("No USERS found with ID : "
//				+ userDto.getUserId()));
//		showsDto.setShowId(save.getShowId());
//		showsDto.setUsers(save.getUsers());
//		return showsDto;
//	}
//
	public Shows saveShow(Shows shows) {
		//System.out.println("SHOWSRVICE" + shows);
		String username = shows.getUsers().getUsername();
		User userRepo = userRepository.findByUsername(username).orElseThrow();
//		UserDetails savedUser = userDetailsService.loadUserByUsername(username);
		
		System.out.println("SAVEDUSER " + userRepo);
		shows.setUsers(userRepo);
		System.out.println(shows);
		//userRepository.findByUsername(shows.user);
		//get current user
//		System.out.println("USERNAME "+ usernameu;
//		User currUser = (User) userDetailsService.loadUserByUsername(username);
//		System.out.println("USERDETAILS " + username);
		//User currUser = userRepository.findByUsername(username)
//			.orElseThrow(() -> new BingeTvException("No USERS found with ID : "
//				+ username));
		//check if show is in db
//		Shows savedShow = showRepository.findById(shows.getShowId())
//				.orElseThrow(() -> new BingeTvException("No Shows found with ID : "
//						+ shows.getShowId()));
//		//add show to user's bingedlist set
		
		ShowsDto map = new ShowsDto();
//		if (savedShow != null) {
//
//			map.setShowId(savedShow.getShowId());
//			map.setShowName(savedShow.getShowName());
//			map.setUsers(savedShow.getUsers());
//			showRepository.save(savedShow);
//			return savedShow;
//		} else {
//			Shows currShow = new Shows();
//			map.setUsers(currShow.getUsers());
//			map.setShowId(shows);
//			map.setShowName(shows);
//			System.out.println("CURRSHOW " + currShow);
		
			Shows savedShow = showRepository.save(shows);
//			var savedUser = userRepository.save(Set<Shows> shows);
		System.out.println("SAVED " + savedShow);
//		//save user
//		//return the users bingedlist set
			return savedShow;
		}
		
//	}
	
	public List<ShowsDto> getAllShows() {
		return showRepository.findAll().stream()
				.map(showMapper::modelToDto)
				.collect(toList());
	}
	
	public ShowsDto getShowById(Long showId) {
		Shows shows = showRepository.findById(showId)
				.orElseThrow(() -> new BingeTvException("No Shows found with ID : "
						+ showId));
		
		return showMapper.modelToDto(shows);
	}
	
	public void deleteShow(Long showId) {
		Shows shows = showRepository.findById(showId)
				.orElseThrow(() ->
						new BingeTvException("No Shows found with ID : "
								+ showId));
		
		showRepository.delete(shows);
	}
	
//	public Set<Shows> addShowToBingedList(User user, Long showId) {
//		//get current user
//		var curUser = authService.getCurrentUser();
//		//check if show is in db
//		var currShow = showRepository.findById(showId)
//				.orElseThrow(() ->
//						new BingeTvException("No Shows found with ID : "
//								+ showId));
//		//if not save show
//		if (currShow == null) showRepository.save(currShow);
//		//add show to user's bingedlist set
//
//		//save user
//		//return the users bingedlist set
//	}


}
