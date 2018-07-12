package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;


@RestController
@RequestMapping("member")
public class MemberController {
@Autowired MemberRepository memberRepository;
	Log log = LogFactory.getLog(MemberController.class);
	
	@GetMapping("/1")
	public void boards(){
		Member member = new Member();
		member.setMember_id("20121201");
		member.setPassword("qwer123");
		member.setEmail("eunho@osstem.com");
		
		memberRepository.save(member);
		log.info("member insert");
	}
	
	@GetMapping("/")
	public void start(){
		
		log.info("member start");
	}
}
