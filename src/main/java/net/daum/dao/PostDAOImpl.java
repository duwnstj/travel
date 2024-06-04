package net.daum.dao;

import java.util.List;
import java.util.Optional;

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
	
	
	  @Autowired private SqlSession sqlSession;
	 
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


	@Override// 게시된 게시글 번호를 기준으로 값 조회하기
	public Community_boardVO getPostInfo(Long mateno) {
		System.out.println(" \n 게시된 게시글 번호를 기준으로 값 조회하기");
		return this.postRepo.getPostInfo(mateno);
	}


	@Override
	public void editBoard(Community_boardVO cb) {
		System.out.println(" \n 게시글 수정");
		this.postRepo.save(cb);
	}


	@Override
	public void editImages(Long mateno, List<String> fileDBNames) {
		Community_boardVO post = postRepo.getPostInfo(mateno);
		
		//기존 이미지 삭제
		if(post.getImages() != null) {
			cmImgRepo.deleteAll(post.getImages());
		}
		//새 이미지 저장
		for(String fileDBName : fileDBNames) {
			Cm_ImgVO newImage = new Cm_ImgVO();
			newImage.setMateno2(mateno);
			newImage.setUploadFile(fileDBName);
			cmImgRepo.save(newImage);
		}
		
	}


	@Override
	public void delpost(Long mateno) {
		System.out.println(" \n 게시물 삭제");
		this.postRepo.deleteById(mateno);
		
	}


	

	 
	}

	



	
	
	
	
	

	
	

	
	

