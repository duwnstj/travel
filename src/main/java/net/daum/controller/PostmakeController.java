package net.daum.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.PostService;
import net.daum.vo.Community_boardVO;


	
	@Controller
public class PostmakeController {

		@Autowired
		private PostService postService;
	@Autowired
	@GetMapping("/postMake")
	public String postmake() {
		return "/jsp/postMake";
	}
	//게시판에 정보 저장
	@PostMapping("/postMake")
	public ModelAndView post_make(Community_boardVO b ,HttpServletResponse response) {
		this.postService.insertboard(b);
		return null;
	}

}
