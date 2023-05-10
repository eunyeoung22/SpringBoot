package user.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.bean.UserDTO;
import user.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public void write(UserDTO userDTO) {
		userDAO.save(userDTO);
		
	}

	@Override
	public List<UserDTO> getuserList() {
		return userDAO.findAll();
	}

	@Override
	public String isExistId(String id) {
		Optional<UserDTO> userDTO = userDAO.findById(id);//id가 없으면 Optional.empty
		
		if(userDTO.isPresent())
		return "exist";
		else
			return "non_exist";
	}

	@Override
	public List<UserDTO> search(Map<String, String> map) {
		String searchOption = map.get("searchOption");
		String keyword = map.get("keyword");
		
		if(searchOption.equals("name"))
			return userDAO.findByNameContaining(keyword);
		else
			return userDAO.findByIdContaining(keyword);
	}

	@Override
	public Optional<UserDTO> getuser(String searchId) {
		Optional<UserDTO> userDTO = userDAO.findById(searchId);
		return userDTO;
	}


}
