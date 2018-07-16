package com.example.demo.domain.request;

import com.example.demo.domain.Board;
import com.example.demo.domain.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BoardRequestDto {
	String title;
	String content;
	int hits;
	String reply_yn;
	String reg_id;
	String mod_id;
	
	public Board toEntity(){
			return Board
					.builder()
					.title(title)
					.content(content)
					.hits(hits)
					.reply_yn(reply_yn)
					.mod_id(mod_id)
					.reg_id(reg_id)
					.build();
		
	}
}
