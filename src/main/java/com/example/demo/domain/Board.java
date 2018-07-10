package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(exclude={"comments","files"})
@EqualsAndHashCode(exclude={"comments","files"})
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bbs_seq;
	
	String title;
	
	String content;
	
	int hits;
	
	String reply_yn;
	
	String reg_dt;
	
	String reg_id;
	
	String mod_dt;
	
	String mod_id;
	
	@JsonIgnore
	@OneToMany(mappedBy="tb_bbs" , fetch = FetchType.LAZY)
	List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy="tb_bbs" , fetch = FetchType.LAZY)
	List<File> files;
	
}
