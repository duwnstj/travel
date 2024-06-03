package net.daum.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import net.daum.service.PostService;
import net.daum.vo.Cm_ImgVO;
import net.daum.vo.Community_boardVO;

@Controller
public class PostmakeController {

	// 사용자 자료실 글쓰기폼으로 이동
	@Autowired
	private PostService postService;

	@GetMapping("/postMake")
	public ModelAndView postmake() {

		ModelAndView wm = new ModelAndView();
		wm.setViewName("jsp/postMake");

		return wm;
	}

	// 게시판에 정보 저장
	@PostMapping("/post_make_Ok")
	public String post_make_ok(@RequestParam("uploadFile2") MultipartFile[] files, Community_boardVO b,
			HttpServletRequest request) {

		String uploadFolder = request.getServletContext().getRealPath("upload");

		this.postService.insertboard(b); // 게시판에 들어갈 제목,내용 등 저장

		for (MultipartFile file : files) {
			if (!file.isEmpty()) {// 파일 리스트가 비어있지않다면
				String originalFilename = file.getOriginalFilename(); // file 원래 이름
				String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 확장자 추출

				Calendar c = Calendar.getInstance();// 현재의 날짜를 담은 calendar 객체 생성
				int year = c.get(Calendar.YEAR);
				int month = c.get(Calendar.MONTH) + 1; // +1해주는 이유는 0~11으로 계산되기 떄문에
				int date = c.get(Calendar.DATE);

				String homedir = uploadFolder + "/" + year + "-" + month + "-" + date;
				File path01 = new File(homedir);

				if (!(path01.exists())) {// 오늘 날짜 폴더 경로가 존재하지 않으면
					path01.mkdir();// 오늘 날짜 폴더 생성
				}
				Random r = new Random();
				int random = r.nextInt(100000000);

				String refileName = "cmimg" + year + month + date + random + "." + fileExtension;// 파일명 랜덤값만
				String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;// 데이터 베이스에 저장하기위한
																								// 파일명(전체경로와 파일명)

				try {
					File saveFile = new File(homedir + "/", refileName);
					file.transferTo(saveFile);

					Cm_ImgVO cm = new Cm_ImgVO();

					cm.setUploadFile(fileDBName);

					this.postService.insertboard(cm); // 업로드 된 이미지 저장
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return "redirect:/community_board";
	}

	
	 // 게시물 목록 조회
	 
	 @RequestMapping(value="/community_board",method=RequestMethod.GET) 
	 public ModelAndView community_board() throws Exception{
	  
	  List<Community_boardVO> postList = postService.getAllPosts();//모든 게시글 데이터
	  //가져오기
	  
	  for(Community_boardVO post : postList) {
		  Long mateNo = post.getMateno(); //게시글의 mate_no 가져오기
		  List<Cm_ImgVO> postImages = new ArrayList<>();
		  
		  for(Cm_ImgVO img : postService.getAllImages()) {
			  if(img.getMateno2() != null && img.getMateno2().equals(mateNo)) {
				  postImages.add(img);
			  }
		  }
		  post.setImages(postImages);
	  }
	  
	  ModelAndView po = new ModelAndView();
	  po.addObject("posts",postList);
	  po.setViewName("/jsp/main");
	  
	  return po;
	 }
	  
	 //게시물 수정폼으로 이동
	 @PostMapping("/post_edit")
	public ModelAndView postedit(@RequestParam("mateno") Long mateno) {
		 //게시글의 등록된 게시물의 정보를 조회하여 가져오는 로직
		 Community_boardVO post=postService.getPostInfo(mateno);
		 List<Cm_ImgVO> images=post.getImages();
		 ModelAndView am = new ModelAndView(); 
		 	am.addObject("postId",post.getMateno());
		 	am.addObject("mate_title", post.getMate_title());
		 	am.addObject("mate_cont",post.getMate_cont());
		 	
		 	//이미지 리스트가 비어있지않다면 mate_image로 추가
		 	if(images != null && !images.isEmpty()) {
		 		
		 		am.addObject("mate_image",images);
		 	}
		  
			
			am.setViewName("/jsp/postEdit");
			
				 return am;
	 }
	 
		
		
		  //수정 완료
		  
		  @PostMapping("post_edit_ok") 
		  public ModelAndView post_edit_ok(@RequestParam("mateno") Long mateno, 
		Community_boardVO cb,@RequestParam("uploadFile") List<MultipartFile> uploadFile,
		  HttpServletRequest request ,HttpServletResponse response ) throws Exception {
		  response.setContentType("text/html;charset=UTF-8");
		  
		  String uploadFolder = request.getServletContext().getRealPath("upload");
		  
		  //게시물 정보 저장 
		  this.postService.editBoard(cb);
		  
		  for (MultipartFile file : uploadFile) {
				if (!file.isEmpty()) {// 파일 리스트가 비어있지않다면
					String originalFilename = file.getOriginalFilename(); // file 원래 이름
					String fileExtension = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 확장자 추출

					Calendar c = Calendar.getInstance();// 현재의 날짜를 담은 calendar 객체 생성
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1; // +1해주는 이유는 0~11으로 계산되기 떄문에
					int date = c.get(Calendar.DATE);

					String homedir = uploadFolder + "/" + year + "-" + month + "-" + date;
					File path01 = new File(homedir);

					if (!(path01.exists())) {// 오늘 날짜 폴더 경로가 존재하지 않으면
						path01.mkdir();// 오늘 날짜 폴더 생성
					}
					Random r = new Random();
					int random = r.nextInt(100000000);

					String refileName = "cmimg" + year + month + date + random + "." + fileExtension;// 파일명 랜덤값만
					String fileDBName = "/" + year + "-" + month + "-" + date + "/" + refileName;// 데이터 베이스에 저장하기위한
																									// 파일명(전체경로와 파일명)

					try {
						File saveFile = new File(homedir + "/", refileName);
						file.transferTo(saveFile);
						
						Cm_ImgVO cm = new Cm_ImgVO();
						cm.setUploadFile(fileDBName);
						cm.setMateno2(mateno);
						
						this.postService.editImages(cm);
					}catch(Exception e) {
						e.printStackTrace();
						}
					}
		  }
		  
		  
		  ModelAndView an = new ModelAndView(); 
		  
		  an.setViewName("redirect:/community_board"); 
		  return an;
		  }
		 
}
