package net.daum.dao;

import java.util.List;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

public interface PostDAO {

	void insertboard(Community_boardVO b);

	void insertboard(Cm_ImgVO cm);

	List<Community_boardVO> getAllposts();

	

}
