package com.mycom.soloProject.board.model.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	
	private int bno;
	private String title;
	private String content;
	private String author;
	private Date write_date;
		
}
