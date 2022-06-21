package org.cory.rice.bingetv.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cory.rice.bingetv.dto.ShowsDto;
import org.cory.rice.bingetv.exceptions.BingeTvException;
import org.cory.rice.bingetv.mappers.ShowMapper;
import org.cory.rice.bingetv.models.Shows;
import org.cory.rice.bingetv.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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
	private ShowMapper showMapper;
	
	public ShowsDto saveShow(ShowsDto showsDto) {
		Shows save = showRepository.save(showMapper.dtoToModel(showsDto));
		showsDto.setShowId(save.getShowId());
		return showsDto;
	}
	
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


}
