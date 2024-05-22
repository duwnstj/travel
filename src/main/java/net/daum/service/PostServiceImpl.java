package net.daum.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.daum.dao.PostDAO;
import net.daum.vo.Community_boardVO;

@Service
public class PostServiceImpl implements PostService {
@Autowired
private PostDAO postDao;
	@Override
	public void insertboard(Community_boardVO b) {
		this.postDao.insertboard(b);
		
	}

}
