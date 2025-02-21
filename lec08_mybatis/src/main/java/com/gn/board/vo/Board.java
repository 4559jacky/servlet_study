package com.gn.board.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private int boardWriter;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	
}
