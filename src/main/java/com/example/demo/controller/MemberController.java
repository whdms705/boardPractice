package com.example.demo.controller;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Member;
import com.example.demo.domain.request.MemberRequestDto;
import com.example.demo.repository.MemberRepository;


@RestController
@RequestMapping("member")
public class MemberController {
	
	@Autowired
	MemberRepository memberRepository;
	Log log = LogFactory.getLog(MemberController.class);
	
	@GetMapping("/1")
	public void boards(){
		LocalDateTime now = LocalDateTime.now();
		memberRepository.save(Member.builder()
				.member_id("123123")
				.password("123123")
				.email("whdms705@naver.com")
				.build()
				);
		log.info("member insert");
	}
	
	@GetMapping("/")
	public void start(){
		
		log.info("member start");
	}
	
	@PostMapping("/")
	public void saveMember(@RequestBody MemberRequestDto member){
		log.info("postman");
		memberRepository.save(member.toEntity());
	}
}
