package user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import user.bean.UserDTO;
import user.service.UserService;

@Controller
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping(value="writeForm")
	public String writeForm() {
		return "user/writeForm";
	}
	
	@PostMapping(value="write")
	@ResponseBody //Dispatcher를 무시하고 리턴해줘라
	public void write(@ModelAttribute UserDTO userDTO){//리턴값이 존재하지 않을 경우 "void"
		userService.write(userDTO);
	}
	
	@GetMapping(value="list")
	public String list(@RequestParam(required = false, defaultValue="1") String pg, Model model) {
		//pg처리 시 jsp수정 없이 무조건 1페이지로 정해서 가지고 다녀야함
		model.addAttribute("pg", pg);
		return "/user/list";
	}
	
	@PostMapping(value="getUserList")
	@ResponseBody//JSON으로 알아서 변환해서 보내준다.
	public Map<String, Object> getUserList(@RequestParam String pg){
		//List<UserDTO> list = userService.getUserList();
		return userService.getUserList(pg);
	}
	
	@PostMapping(value="isExistId")
	@ResponseBody
	public String isExistId(@RequestParam String id) {
		return userService.isExistId(id);
	}
	
	@PostMapping(value="getUser")
	@ResponseBody
	public UserDTO getUser(@RequestParam String id) {
		return userService.getUser(id);
	}
	
	@GetMapping(value="updateForm")
	public String updateForm() {
		return "user/updateForm";
	}
	
	@PostMapping(value="update")
	@ResponseBody //Dispatcher를 무시하고 리턴해줘라
	public void update(@ModelAttribute UserDTO userDTO){//리턴값이 존재하지 않을 경우 "void"
		userService.update(userDTO);
	}
	
	@GetMapping(value="deleteForm")
	public String deleteForm() {
		return "user/deleteForm";
	}
	
	@PostMapping(value="delete")
	@ResponseBody //Dispatcher를 무시하고 리턴해줘라
	public void update(@RequestParam String id){//리턴값이 존재하지 않을 경우 "void"
		userService.delete(id);
	}
	
	
	

}
