package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="tb_comment")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int comment_seq;
	
	@ManyToOne
	@JoinColumn(name = "bbs_seq")
	Board board;
	
	
	int sorts;
	
	int depth;
	
	String content;
	
	String reg_dt;
	
	String reg_id;
	
	String mod_dt;
	
	String mod_id;
	

}
