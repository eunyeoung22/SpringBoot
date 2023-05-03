package user.controller;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import user.bean.UserImageDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController2 {
	@Autowired
	private UserService userService;
	
	//파일 업로드
	@GetMapping(value="uploadForm")
	public String uploadForm() {
		return "user/uploadForm";
	}
	
	@GetMapping(value="uploadForm_AJax")
	public String uploadForm_AJax() {
		return "user/uploadForm_AJax";
	}
	
	//***************************** name="img"1개 일때 *******************************************
//	@PostMapping(value="upload", produces="text/html; charset=UTF-8")//한글이미지명 파일 올리기
//	@ResponseBody
//	public String upload(@RequestParam MultipartFile img, 
//						 @ModelAttribute UserImageDTO userImageDTO,
//						 HttpSession session){
//		//가상 폴더는 내가 관리하는 폴더에만 올라가는거라 나만 볼수 있다(실제로는 사용안해도 됨)
//		//String filePath_lier = "D:/Spring/workspace/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage"; 
//		
//		//실제 폴더 올려야지만 사용자에게 이미지 노출 가능 (실제 사용하는 방식) 
//		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//		System.out.println("실제 폴더 = " + filePath);
//		
//		String fileName = img.getOriginalFilename();
//		
//		File file = new File(filePath, fileName);
//		//File file_lier = new File(filePath_lier, fileName);
//		
//		try {
//			//FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file_lier));//파일복사
//			img.transferTo(file);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		userImageDTO.setImage1(fileName);
//		
//		//UserSevice -> UserDAO -> userMapper.xml
//		return "<img src = '../storage/" + fileName + "' width='300' height='300'/>";
//	}
	
	//***************************** name="img"2개 이상 일때 *******************************************
	/*
	@PostMapping(value="upload", produces="text/html; charset=UTF-8")//한글이미지명 파일 올리기
	@ResponseBody
	public String upload(@RequestParam MultipartFile[] img, 
						 @ModelAttribute UserImageDTO userImageDTO,
						 HttpSession session){
		//가상 폴더는 내가 관리하는 폴더에만 올라가는거라 나만 볼수 있다(실제로는 사용안해도 됨)
		//String filePath_lier = "D:/Spring/workspace/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage"; 
		
		//실제 폴더 올려야지만 사용자에게 이미지 노출 가능 (실제 사용하는 방식) 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		String fileName; 
		File file;
		
		if(img[0] != null) {
			fileName = img[0].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img[0].transferTo(file);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(img[1] != null) {
			fileName = img[1].getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img[1].transferTo(file);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "이미지 등록 완료";
	}
	*/
	//***************************** 한번에 파일 여러개 선택 *******************************************
	@PostMapping(value="upload", produces="text/html; charset=UTF-8")//한글이미지명 파일 올리기
	@ResponseBody
	public String upload(@RequestParam("img[]") List<MultipartFile> list, 
						 @ModelAttribute UserImageDTO userImageDTO,
						 HttpSession session){
		//가상 폴더는 내가 관리하는 폴더에만 올라가는거라 나만 볼수 있다(실제로는 사용안해도 됨)
		//String filePath_lier = "D:/Spring/workspace/chapter06_SpringWebMaven/src/main/webapp/WEB-INF/storage"; 
		
		//실제 폴더 올려야지만 사용자에게 이미지 노출 가능 (실제 사용하는 방식) 
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제 폴더 = " + filePath);
		
		String fileName; 
		File file;
		
		List<String> fileNameList = new ArrayList<String>();
		
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img.transferTo(file);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			fileNameList.add(fileName);
		}//for
	
		userService.upload(userImageDTO, fileNameList);
		return "이미지 등록 완료";
	}
	
	@GetMapping(value="uploadForm_AJax_list")
	public String uploadForm_AJax_list() {
		return "user/uploadForm_AJax_list";
	}
	
	@PostMapping(value="getImageList")
	@ResponseBody//JSON으로 알아서 변환해서 보내준다.
	public List<UserImageDTO> getImageList(){
		return userService.getImageList();
	}
	
	
}
