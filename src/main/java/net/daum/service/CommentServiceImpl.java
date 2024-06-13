package net.daum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.CommentDAO;
import net.daum.vo.Cm_CommentVO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO commentdao;


	
}
