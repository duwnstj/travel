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
	@GetMapping("/postMake")
	public String postmake() {
		return "/jsp/postMake";
		
		
	}

	
	
	
	//게시판에 정보 저장
	@PostMapping("/post_make_Ok")
	public ModelAndView post_make(Community_boardVO b ,HttpServletResponse response)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		this.postService.insertboard(b);
		
		ModelAndView am = new ModelAndView();
		am.addObject("mate_id",b.getMember_no());
		am.addObject("mate_hit",b.getMate_hit());
		am.addObject("mate_title",b.getMate_title());
		am.addObject("mate_cont",b.getMate_cont());
		am.addObject("make_date",b.getMakedate());
		am.addObject("updatedate",b.getUpdatedate());
		am.addObject("mate_matching",b.getMate_matching());
		am.addObject("mate_sumnail",b.getMate_sumnail());
		am.setViewName("/jsp/main");
		return am;
		
		
		
	}
	
}
