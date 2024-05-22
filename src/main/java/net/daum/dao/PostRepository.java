package net.daum.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.daum.vo.Community_boardVO;

public interface PostRepository extends JpaRepository<Community_boardVO, Integer> {

	
}
