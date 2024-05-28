package net.daum.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Integer> {


	List<Community_boardVO> findByMate_titleContaining(String find_name);

	List<Community_boardVO> findByMate_contContaining( String find_name);

	List<Community_boardVO> findByMt_hashtagContaining(String find_name);

	
	

	

	

	
}
