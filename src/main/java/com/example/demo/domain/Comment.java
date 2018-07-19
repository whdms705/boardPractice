package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="tb_comment")
public class Comment extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long comment_seq;
	
	@ManyToOne
	@JoinColumn(name = "bbs_seq")
	Board board;
	
	int sorts;
	
	int cgroup;
	
	int depth;
	
	String content;
	
	@ManyToOne
	@JoinColumn(name="reg_id")
	Member member;
	
	String mod_id;
	
	@Builder
	public Comment(Long bbs_seq,int sorts,int cgroup,int depth,String content,String reg_id,String mod_id){
		Board board = new Board();
		board.setBbs_seq(bbs_seq);
		
		Member member = new Member();
		member.setMember_id(reg_id);
		this.board=board;
		this.sorts=sorts;
		this.cgroup=cgroup;
		this.depth=depth;
		this.content=content;
		this.member=member;
		this.mod_id=mod_id;
	}

}
