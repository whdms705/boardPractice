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
	int cgroup;
	int sorts;
	int depth;
	String comment;
	String reg_id;
	String mod_id;
	
	public Comment toEntity(){
		return Comment
				.builder()
				.bbs_seq(bbs_seq)
				.cgroup(cgroup)
				.sorts(sorts)
				.depth(depth)
				.comment(comment)
				.reg_id(reg_id)
				.mod_id(mod_id)
				.build();
				
	
	}
}
