package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;

@RestController
@RequestMapping("board")
public class BoardController {
	@Autowired BoardRepository boardRepository;
	
	@RequestMapping("boards")
	public List<Board> boards(){
		return boardRepository.findAll();
	}
}
