package person.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import person.bean.PersonDTO;
import person.service.PersonService;


@Controller
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/person/writeForm")
	public String writeForm() {
		return "/person/writeForm";
	}
	
	@PostMapping("person/write")
	@ResponseBody//ajax로 돌아가야하니 
	public void write(@RequestParam MultipartFile img,
					  @ModelAttribute PersonDTO personDTO,
					  HttpSession session) {
		System.out.println(img.getOriginalFilename());
		System.out.println(personDTO.getName() + " " + personDTO.getAge());
		
		//실제폴더
		String filePath = session.getServletContext().getRealPath("/storage");
		
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath,fileName);
		System.out.println("실제 폴더: " + filePath);
	
			try {
				img.transferTo(file);
			} 	
			 catch (IOException e) {
				e.printStackTrace();
			}
		
		personDTO.setPhoto(fileName);
		personService.write(personDTO);
	}
	
	
	@GetMapping(value="/person/list")
	public String list() {
		return "/person/list";
	}
	
	@PostMapping("person/getPersonList")
	@ResponseBody
	public List<PersonDTO> getPersonList() {
		return personService.getPersonList();
	}
	
}
	

