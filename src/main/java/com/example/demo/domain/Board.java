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

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString(exclude={"comments","files"})
@EqualsAndHashCode(exclude={"comments","files"})
@Entity
@Table(name="tb_bbs")
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bbs_seq;
	
	String title;
	
	String content;
	
	int hits;
	
	String reply_yn;
	
	String reg_dt;
	
	@ManyToOne
	@JoinColumn(name = "reg_id")
	Member member;
	
	String mod_dt;
	
	String mod_id;
	
	@JsonIgnore
	@OneToMany(mappedBy="board" , fetch = FetchType.LAZY)
	List<Comment> comments;
	
	@JsonIgnore
	@OneToMany(mappedBy="board" , fetch = FetchType.LAZY)
	List<File> files;
	
}
