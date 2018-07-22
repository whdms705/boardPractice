package com.example.demo.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.request.CommentRequestDto;
import com.example.demo.repository.CommentRepository;
import com.example.demo.service.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {

	Log log = LogFactory.getLog(CommentController.class);
	CommentService commentService;
	@Autowired CommentRepository commentRepository;
	
	@PostMapping("/")
	public void insertComment(@RequestBody CommentRequestDto comment){
		log.info("insert start comment");
		//commentService.insertComment(comment);
		int gubun = commentRepository.commentGubun(comment.getCgroup(),comment.getSorts(),comment.getDepth());
		log.info("gubun value : "+gubun);
		log.info("insert end comment");
	}
}
