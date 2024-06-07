package net.daum.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Long> {

	// 게시물 페이징 조회
	@Query(value = "SELECT * FROM (SELECT a.*, ROWNUM rnum FROM (SELECT * FROM community_board ORDER BY mateno DESC) a WHERE ROWNUM <= :#{#pageable.offset + #pageable.pageSize}) WHERE rnum > :#{#pageable.offset}", countQuery = "SELECT COUNT(*) FROM community_board", nativeQuery = true)
	Page<Community_boardVO> getAllPosts(Pageable pageable);

	@Query(value = "SELECT COUNT(*) FROM community_board WHERE mate_title LIKE CONCAT('%', :searchkeyword, '%') OR mate_cont LIKE CONCAT('%', :searchkeyword, '%') OR mt_hashtag LIKE CONCAT('%', :searchkeyword, '%')", nativeQuery = true)
	Page<Community_boardVO> searchPosts(@Param("searchkeyword") String searchkeyword, Pageable pageable);
		
	

	// 게시물 번호 조회
	@Query("select max(c.mateno) from Community_boardVO c ")
	public Long getMaxMateNo();

	// 게시물 이미지 조회
	@Query("select p from Community_boardVO p WHERE p.mateno = :mateno")
	public Community_boardVO getPostInfo(@Param("mateno") Long mateno);

	

	

	
}