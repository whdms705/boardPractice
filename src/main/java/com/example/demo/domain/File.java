package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class File {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int bbs_file_seq;
	
	@ManyToOne
	@JoinColumn(name = "bbs_seq")
	Board board;
	
	String file_nm;
	
	String file_size;
	
	String file_type;
	
	String reg_dt;
	
	String reg_id;
}
