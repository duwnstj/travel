package net.daum.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

@Repository
public class PostDAOImpl implements PostDAO {

	@Autowired
	private PostRepository postRepo;
	
	@Autowired  
	private CmImgRepository cmImgRepo;
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertboard(Community_boardVO b) {
		
		System.out.println(" \n 게시물 저장과 업로드된 이미지 저장 =========>");
		Long mate_no=this.sqlSession.selectOne("mateNoSeq_Find");
		b.setMateno(mate_no);
		this.postRepo.save(b);		
	}


	@Override
	public void insertboard(Cm_ImgVO cm) {
		System.out.println(" \n 다중 파일 업로드 저장(JPA) ==========>");
		
		cm.setMateno2(postRepo.getMaxMateNo());
		this.cmImgRepo.save(cm);		
	}	
	
	
	
	@Override
	public List<Community_boardVO> getAllposts() {
		System.out.println(" \n 저장된 값 조회하기");
		return this.postRepo.findAll();
	}//게시글 출력


	@Override
	public List<Cm_ImgVO> getAllImages() {
		System.out.println(" \n 저장된 이미지 가져오기");
		return this.cmImgRepo.findAll();
	}
	
	
}
	
	

