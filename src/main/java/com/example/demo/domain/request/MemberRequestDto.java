package com.example.demo.domain.request;

import com.example.demo.domain.Member;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {
	
	String member_id;
	String password;
	String email;
	
	public Member toEntity(){
		return Member
				.builder()
				.member_id(member_id)
				.password(password)
				.email(email)
				.build();
	}

}
