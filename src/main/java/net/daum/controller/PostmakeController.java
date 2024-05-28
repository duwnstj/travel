package net.daum.controller;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.PostService;
import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;


	
	@Controller
public class PostmakeController {

		//사용자 자료실 글쓰기폼으로 이동
		@Autowired
		private PostService postService;
		
	@GetMapping("/postMake")
	public ModelAndView postmake() {
		
		ModelAndView wm = new ModelAndView();
		wm.setViewName("jsp/postMake");
		
		return wm;
	}
	
	
	
	
	//게시판에 정보 저장
	@PostMapping("/post_make_Ok")
	public String post_make_ok(Cm_ImgVO cm ,Community_boardVO b , HttpServletRequest request) {
		
		String uploadFolder = 
				request.getServletContext().getRealPath("upload");
		
		MultipartFile uploadFile = cm.getUploadFile2();//첨부파일을 가져옴
		if(!uploadFile.isEmpty()) {//첨부파일이 있는 경우
			String fileName= uploadFile.getOriginalFilename();//첨부원본파일명
			Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH)+1; 
			int date = c.get(Calendar.DATE);
			
			String homedir =uploadFolder+"/"+year+"-"+month+"-"+date;
			File path01=new File(homedir);
			
			if(!(path01.exists())) {//오늘 날짜 폴더 경로가 존재하지 않으면 
				path01.mkdir();//오늘 날짜 폴더 생성
			}
			Random r = new Random();
			int random = r.nextInt(100000000);
			
			int index = fileName.lastIndexOf(".");
			String fileExtendsion=fileName.substring(index+1);
			String refileName="cmimg"+year+month+date+random+"."+fileExtendsion;
			String fileDBName = "/"+year+"-"+month+"-"+date+"/"+refileName;
			
			cm.setUploadFile(fileDBName);
			
			File saveFile = new File(homedir+"/",refileName);
			
			try {
				uploadFile.transferTo(saveFile); //upload폴더 오늘 날짜 폴더에
				//변경된 파일로 실제 업로드 
			}catch(Exception e) {
				e.printStackTrace();
				}
		}else {//파일을 첨부하지 않았을 때 실행
			String fileDBName="";
			cm.setUploadFile(fileDBName);
		}
		this.postService.insertboard(cm); //업로드 된 이미지 저장
		this.postService.insertboard(b); // 게시판에 들어갈 제목,내용 등 저장
		
		return "redirect:/post_make";
	}
	
	//자료실 목록
	@RequestMapping(value="/post_make",method=RequestMethod.GET)
	public ModelAndView post_make()
	throws Exception{
		List<Community_boardVO> posts = postService.getAllPosts();//모든 게시글 데이터 가져오기
		
		ModelAndView po = new ModelAndView();
		po.addObject("posts",posts);
		po.setViewName("/jsp/main");
		
		return po;
		
		//게시판 조회수 증가
		
		
		
		
	}
	
}
