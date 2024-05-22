package net.daum.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.Community_boardVO;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private PostRepository postRepo; 
	@Override
	public void insertboard(Community_boardVO b) {
		System.out.println(" \n 게시물 저장 =========>");
		b.setMate_postuse(1);
		this.postRepo.save(b);
	}

}
