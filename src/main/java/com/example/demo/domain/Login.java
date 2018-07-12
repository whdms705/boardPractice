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
@Table(name="tb_login")
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int login_seq;
	
	@ManyToOne
	@JoinColumn(name = "member_id")
	Member member;
	
	String login_dt;
	
	String logout_dt;
	
	
	
}
