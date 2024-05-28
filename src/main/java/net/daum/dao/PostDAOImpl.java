package net.daum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired
	private CmImgRepository cmImgRepo;
	
	@Override
	public void insertboard(Community_boardVO b) {
		System.out.println(" \n 게시물 저장 =========>");
		
		this.postRepo.save(b);
	}
	@Override
	public void insertboard(Cm_ImgVO cm) {
		System.out.println(" \n 업로드된 이미지 저장 =========>");
		
		this.cmImgRepo.save(cm);
		
	}
	@Override
	public List<Community_boardVO> getAllposts() {
		
		return this.postRepo.findAll();
	}

}
