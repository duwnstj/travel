package net.daum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.PostDAO;
import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

@Service
public class PostServiceImpl implements PostService {
	
@Autowired
private PostDAO postDao;

	@Override
	@Transactional
	public void insertboard(Community_boardVO b) {
		this.postDao.insertboard(b);
		
	}
	@Override
	@Transactional
	public void insertboard(Cm_ImgVO cm) {
		this.postDao.insertboard(cm);
		
	}

	@Override
	public List<Community_boardVO> getAllPosts() {
		
		return this.postDao.getAllposts();
	}
	
	@Override
	public List<Cm_ImgVO> getImagesByMateNo(Long mateNo) {
		
		return this.postDao.getImagesByMateNo(mateNo);
		
	}
	
	

}
