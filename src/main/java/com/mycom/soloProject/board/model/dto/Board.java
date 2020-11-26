package com.mycom.soloProject.board.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int bno;
	
	@NotNull
	@Length(min = 2, message = "제목을 2글자 이상 입력해주세요.")
	private String title;
	
	@NotNull
	@Length(min = 2, message = "내용을 2글자 이상 입력해주세요.")
	private String content;
	
	@NotNull
	@Length(min = 2, message = "저자를 2글자 이상 입력해주세요.")
	private String author;
	
	private Date write_date;
		
}
