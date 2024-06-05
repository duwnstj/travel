package net.daum.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;



public interface PostService {

	void insertboard(Community_boardVO b);
	
	void insertboard(Cm_ImgVO cm);
	
	Page<Community_boardVO> getAllPosts(Pageable pageable);

	

	Community_boardVO getPostInfo(Long mateno);

	void editBoard(Community_boardVO cb);

	void editImages(Long mateno, List<String> fileDBNames);

	void delpost(Long mateno);

	List<Community_boardVO> searchPosts(String searchInput);

	

	



	

	

	

	



	

	

	


	

}
