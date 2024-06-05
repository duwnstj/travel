package net.daum.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Long> {

	// 게시물 페이징 조회
	@Query(value = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM community_board ORDER BY mateno DESC) a WHERE ROWNUM <= :#{#pageable.offset + #pageable.pageSize}) WHERE rnum > :#{#pageable.offset}", 
	           countQuery = "SELECT COUNT(*) FROM community_board",
	           nativeQuery = true)
	Page<Community_boardVO> getAllPosts(Pageable pageable);

	// 게시물 번호 조회
	@Query("select max(c.mateno) from Community_boardVO c ")
	public Long getMaxMateNo();

	// 게시물 이미지 조회
	@Query("select p from Community_boardVO p WHERE p.mateno = :mateno")
	public Community_boardVO getPostInfo(@Param("mateno") Long mateno);

	
	@Query("SELECT p FROM Community_boardVO p WHERE p.mate_title=?1")
	List<Community_boardVO> searchPosts( String searchInput);

	

}