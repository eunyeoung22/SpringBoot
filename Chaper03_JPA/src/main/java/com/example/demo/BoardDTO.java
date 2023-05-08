package com.example.demo;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity //DB테이블과 연관되어 있다라는 표식
@Table(name="board")//board라는 테이블 생성됨
@Data
@SequenceGenerator(name = "BOARD_SEQ_GENERATOR",
				   sequenceName= "BOARD_SEQ",
				   initialValue = 1,
				   allocationSize=1)
public class BoardDTO {
		@Id
		@Column(name="seq")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOARD_SEQ_GENERATOR")
		private int seq;
	
		//@Id //primary key 표식
		@Column(name="id", nullable = false, unique = true, length = 30)//테이블 컬럼 지정:not null, unique, varchar(30)
		private String id;
		
		@Column(name="name", nullable = false, length = 30)
		private String name;
		
		@Column(name="subject")//길이값 없이 varchar로만 지정
		private String subject;
		
		@Column(name="content")
		private String content;
		
		@CreationTimestamp
		private Timestamp logtime;
		

}
