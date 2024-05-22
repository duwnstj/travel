package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class CommunityController {

	@Autowired
	@GetMapping("/community_board")
	public String community_board() {
		return "jsp/main";
	}
	
	//해시태그로 검색 기능
	
	

}
