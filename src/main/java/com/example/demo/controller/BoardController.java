package com.example.demo.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Board;
import com.example.demo.domain.request.BoardRequestDto;
import com.example.demo.repository.BoardRepository;

@RestController
@RequestMapping("board")
public class BoardController {
	
	@Autowired BoardRepository boardRepository;
	Log log = LogFactory.getLog(BoardController.class);
	
	@GetMapping("/")
	public List<Board> findAllBoards(){
		return boardRepository.findAll();
	}
	
	@PostMapping("/")
	public void insertBoards(@RequestBody BoardRequestDto board){
		log.info("board insert");
		System.out.println(board);
		boardRepository.save(board.toEntity());
	}
	
	@GetMapping("/{bbs_seq}")
	public List<Board> boards(){
		return boardRepository.findAll();
	}
}
