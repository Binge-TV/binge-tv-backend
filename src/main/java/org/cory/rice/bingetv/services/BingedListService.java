//package org.cory.rice.bingetv.services;
//
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.cory.rice.bingetv.dto.BingedListDto;
//import org.cory.rice.bingetv.dto.ShowsDto;
//import org.cory.rice.bingetv.models.BingedList;
//import org.cory.rice.bingetv.models.Shows;
//import org.cory.rice.bingetv.models.User;
//import org.cory.rice.bingetv.repository.BingedListRepository;
//import org.cory.rice.bingetv.repository.ShowRepository;
//import org.cory.rice.bingetv.repository.UserRepository;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//@AllArgsConstructor
//@Transactional
//@Slf4j
//public class BingedListService {
//
//	private final ShowRepository showRepository;
//	private final BingedListRepository bingedListRepository;
//	private final UserRepository userRepository;
//	private final AuthService authService;
//
//	public Set<BingedList> saveNewShow(BingedListDto bingedListDto, Long showId) {
//		//get current user
//		User owner = authService.getCurrentUser();
//		//get bingedlist by owner
//		BingedList bingedList = bingedListDto.getOwner().getBingedList();
//		//get show by ID
//		Optional<Shows> currentShow = showRepository.findById(showId);
//		//set show into bungedlist with user as owner
//		bingedList.setOwner(owner);
//
//		//save
//		//return bingedlist
//		return null;
//
//	}
//}
