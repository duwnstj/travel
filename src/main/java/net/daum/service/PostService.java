package net.daum.service;

import java.util.List;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

public interface PostService {

	void insertboard(Community_boardVO b);
	
	void insertboard(Cm_ImgVO cm);
	
	

	List<Community_boardVO> getAllPosts();

	List<Cm_ImgVO> getAllImages();

	


	

}
