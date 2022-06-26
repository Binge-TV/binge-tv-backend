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
	private UserRepository userRepository;
	
	public Object saveShow(Shows shows) {
		String username = shows.getUsers().getUsername();
		Long showsId = shows.getShowId();
		User userRepo = userRepository.findByUsername(username).orElseThrow();
		System.out.println("USER " + shows.getShowName() + userRepo.getUserId());
		//System.out.print("CHECKUSER " + showsRepo);
//		if (showsRepo == shows.getShowId() ) {
//			return null;//new BingeTvException(username + " already has this show in their collection.");
//		}
			
//
			shows.setUsers(userRepo);
			Shows savedShow = showRepository.save(shows);
		System.out.println(savedShow);
			return savedShow;
		
	}
		

		
		
	
	public List<ShowsDto> getAllShows() {
		return showRepository.findAll().stream()
				.map(showMapper::modelToDto)
				.collect(toList());
	}
	
	public ShowsDto getShowById(Long showId) {
		Shows shows = showRepository.findByShowId(showId)
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
}
