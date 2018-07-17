package com.example.demo.domain.request;

import com.example.demo.domain.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentRequestDto {
	Long bbs_seq;
	int sorts;
	int depth;
	String content;
	String reg_id;
	String mod_id;
	
	public Comment toEntity(){
		return Comment
				.builder()
				.bbs_seq(bbs_seq)
				.sorts(sorts)
				.depth(depth)
				.content(content)
				.reg_id(reg_id)
				.mod_id(mod_id)
				.build();
				
	
	}
}