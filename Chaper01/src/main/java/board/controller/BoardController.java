package board.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import board.bean.BoardDTO;

@RestController
public class BoardController {
	
	public BoardController() {
		
		System.out.println("BoardController 기본생성자");
		
	}
	
	@GetMapping(value="/board/hello")//충돌나지 않게 같은 경로 앞에 선행 경로 작성해주기
	//@ResponseBody
	public String hello(String name) {
		
		return "안녕하세요" +  name + "님";
	}
	
	@GetMapping(value="/board/getBoardList")
		public List<BoardDTO> getBoardList() {
		
			List<BoardDTO>list=new ArrayList<BoardDTO>();
			
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setSeq(1);
			boardDTO.setName("허균");
			boardDTO.setSubject("홍길동전");
			boardDTO.setContent("의로운 의적");
			boardDTO.setLogtime(new Date());
			list.add(boardDTO);
			
			boardDTO = new BoardDTO();
			boardDTO.setSeq(2);
			boardDTO.setName("김길동");
			boardDTO.setSubject("하루하루");
			boardDTO.setContent("재밌게 놀자");
			boardDTO.setLogtime(new Date());
			
			list.add(boardDTO);
			
			return list;
	}
	
}

/*
 @RestController는 JSP 같은 뷰를 별도로 만들지 않는 대신에 컨트롤러 메소드가 리턴하는 데이터 자체를 클라이언트로 보낸다.
 클라이언트에 전달되는 데이터는 문자열, DTO, 컬렉션 형태의 자바 객체인데, 자바 객체가 전달되는 경우에는 자동으로 JSON으로 변환하여
 처리하게 된다.
 */
