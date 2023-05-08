package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;
	

	@Override
	public void write() {
		BoardDTO boardDTO = new BoardDTO();
		
		boardDTO.setId("Alia");
		boardDTO.setName("알라딘");
		boardDTO.setSubject("알라딘입니다..");
		boardDTO.setContent("양탄자를 타고 다니지요.");
		
		boardDAO.save(boardDTO);
	}


	@Override
	public List<BoardDTO> getBoardList() {
		return boardDAO.findAll();
	}

}
