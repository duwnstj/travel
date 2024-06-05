package net.daum.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;



public interface PostDAO {

	void insertboard(Community_boardVO b);

	void insertboard(Cm_ImgVO cm);
	
	Page<Community_boardVO> getAllposts(Pageable pageable);


	

	Community_boardVO getPostInfo(Long mateno);

	void editBoard(Community_boardVO cb);


	void editImages(Long mateno, List<String> fileDBNames);

	void delpost(Long mateno);

	List<Community_boardVO> searchPosts(String searchInput);



	

	




	

	

	

	



	
	

	

	

}
