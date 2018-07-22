package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.request.CommentRequestDto;
import com.example.demo.service.CommentService;

public class CommentController {

	Log log = LogFactory.getLog(CommentController.class);
	CommentService commentService;
	
	public void insertComment(@RequestBody CommentRequestDto comment){
		log.info("insert start comment");
		commentService.insertComment(comment);
		log.info("insert end comment");
	}
}
