package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name="tb_member")
public class Member extends BaseTimeEntity{
	
	@Id
	String member_id;
	
	String password;
	
	String email;
	
	@JsonIgnore
	@OneToMany(mappedBy="member", fetch = FetchType.LAZY)
	List<Login> logins;
	
	@JsonIgnore
	@OneToMany(mappedBy="member", fetch = FetchType.LAZY)
	List<Board> boards;
	
	/*@JsonIgnore
	@OneToMany(mappedBy="jmember", fetch = FetchType.LAZY)
	List<Comment> commets;*/
	
	@Builder
	public Member(String member_id,String password,String email){
		this.member_id=member_id;
		this.password=password;
		this.email=email;
	}
	
}
