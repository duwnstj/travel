package net.daum.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Long> {

	//게시물 번호 조회
	@Query("select max(c.mateno) from Community_boardVO c ")
	//@Query("SELECT c.mateno FROM Community_boardVO c")
	public Long getMaxMateNo();

	
	//게시물 이미지 조회
	@Query("SELECT p FROM Community_boardVO p LEFT JOIN FETCH p.images WHERE p.mateno = :mateno")
	public Community_boardVO getPostInfo(@Param("mateno") Long mateno);

	


	

		
}