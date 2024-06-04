package net.daum.service;

import java.util.List;

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
	public void insertboard(Community_boardVO b) {
		this.postDao.insertboard(b);		
	}

	@Override
	public void insertboard(Cm_ImgVO cm) {
		this.postDao.insertboard(cm);		
	}
	

	
	@Override
	public List<Community_boardVO> getAllPosts() {

		return this.postDao.getAllposts();
	}

	@Override
	public List<Cm_ImgVO> getAllImages() {
		
		return this.postDao.getAllImages();
	}

	@Override
	public Community_boardVO getPostInfo(Long mateno) {
		
		return this.postDao.getPostInfo(mateno);
	}

	@Override
	public void editBoard(Community_boardVO cb) {
		
		this.postDao.editBoard(cb);
		
	}

	

	@Override
	public void editImages(Long mateno, List<String> fileDBNames) {
		this.postDao.editImages(mateno , fileDBNames);
	}

	@Override
	public void delpost(Long mateno) {
		this.postDao.delpost(mateno);
		
	}

	
	

	
	

	
	

	
	

	




}




