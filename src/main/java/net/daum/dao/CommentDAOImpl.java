package net.daum.dao;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.Cm_CommentVO;
import net.daum.vo.Community_boardVO;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Autowired
	private CommentRepository commentRepo;
	@Autowired
	private PostRepository postRepo;

	
	



	
	
}
