package user.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("writeForm")
	public String writeForm() {
		return "user/writeForm";
		
	}
	
	@PostMapping("write")
	@ResponseBody //브라우저로 바로 띄워라 "return"은 jsp로 돌아갈때
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@GetMapping("list")
	public String list() {
		return "user/list";
	}
	@PostMapping("getuserList")
	@ResponseBody 
	public List<UserDTO> getuserList() {
		List<UserDTO> list = userService.getuserList();
		System.out.println(list);
		return list;
	}
	
	@PostMapping("isExistId")
	@ResponseBody //문자열로 리턴
	public String isExistId(@RequestParam String id) {
		String result = userService.isExistId(id);
		return result;
	}
	
	@PostMapping("search")
	@ResponseBody
	public List<UserDTO> search(@RequestParam Map<String, String> map){
		List<UserDTO> list = userService.search(map);
		return list;
	}
	
	@GetMapping("updateForm")
	public String updateForm() {
		return "/user/updateForm";
	}
	@PostMapping("getuser")
	@ResponseBody
	public Optional<UserDTO> getuser(@RequestParam String searchId){
		System.out.println(searchId);
		Optional<UserDTO> userDTO = userService.getuser(searchId); 
		return userDTO;
				
		
	}

}
