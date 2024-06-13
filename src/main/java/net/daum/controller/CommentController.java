package net.daum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.daum.service.CommentService;
import net.daum.vo.Cm_CommentVO;


@Controller
public class CommentController {

	@Autowired
	private CommentService commentservice;
	

		
	}

