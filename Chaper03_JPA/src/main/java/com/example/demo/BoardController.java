package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //ResponseBody를 쓰지 않아도 문자열 됨
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping(value="/board/boardWrite")
	public String write() {
		boardService.write();
		return "게시판 등록 성공";//문자열을 브라우저에 바로 뿌린다.
	}
	
	@GetMapping(value="/board/getBoardList")
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> list = boardService.getBoardList();
		return list;
	}

}
