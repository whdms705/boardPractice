package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(exclude={"comments","files"})
@EqualsAndHashCode(exclude={"comments","files"})
@Entity
@Table(name="tb_bbs")
public class Board extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long bbs_seq;
	
	String title;
	
	String content;
	
	int hits;
	
	String reply_yn;
	
	@ManyToOne
	@JoinColumn(name = "reg_id")
	Member member;
	
	
	String mod_id;
	
	@JsonIgnore
	@OneToMany(mappedBy="board" , fetch = FetchType.LAZY)
	List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy="board" , fetch = FetchType.LAZY)
	List<File> files;
	
	@Builder
	public Board(String title,String content,int hits,String reply_yn,String reg_id,String mod_id){
		this.title=title;
		this.content=content;
		this.hits=hits;
		this.reply_yn=reply_yn;
		this.member.member_id=reg_id;
		this.mod_id=mod_id;
	}
	
}
