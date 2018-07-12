package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;



@Data
@ToString(exclude={"logins","boards","commets"})
@EqualsAndHashCode(exclude={"logins","boards","commets"})
@Entity
@Table(name="tb_member")
public class Member{
	
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
	
	
	
}
