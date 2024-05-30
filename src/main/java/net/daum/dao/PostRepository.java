package net.daum.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Long> {

	@Query("select max(c.mateno) from Community_boardVO c ")
	public Long getMaxMateNo();

	

		
}