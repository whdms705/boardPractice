package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberControllerTest {

	@Autowired
	MemberRepository memberRepository;
	
	@After
	public void cleanup(){
		//memberRepository.deleteAll();
	}
	
	//member insert test
	@Test
	public void memberInsert(){
		//given
		memberRepository.save(Member.builder()
				.member_id("sssss")
				.password("sssss")
				.email("sss@ssss")
				.build()
				);
		
		//when
		List<Member> memberList = memberRepository.findAll();
		
		//then
		Member member = memberList.get(0);
		assertThat(member.getMember_id(),is("sssss"));
		assertThat(member.getEmail(),is("sss@ssss"));
		
		
		
	}
	
	//time test
	@Test
	public void baseTimeEntityTest(){
		//given
		LocalDateTime now = LocalDateTime.now();
		memberRepository.save(Member.builder()
				.member_id("whdms")
				.password("qwe1244")
				.email("whdms705@nate.com")
				.build()
				);
		//when
		List<Member> memberList = memberRepository.findAll();
		
		//then
		Member member = memberList.get(memberList.size()-1);
		assertTrue(member.getReg_dt().isAfter(now));
		assertTrue(member.getMod_dt().isAfter(now));
	}
	
	
	
}
