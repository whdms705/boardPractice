package com.example.demo.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CommentController;
import com.example.demo.domain.request.CommentRequestDto;
import com.example.demo.repository.CommentRepository;

@Service
public class CommentService {
	@Autowired CommentRepository commentRepository;
	Log log = LogFactory.getLog(CommentService.class);
	
	public void insertComment(CommentRequestDto comment){
		if(comment.getSorts()==0){
			commentRepository.save(comment.toEntity());
		}else{
			int gubun = commentRepository.commentGubun(comment.getCgroup(),comment.getSorts(),comment.getDepth());
			
		}
	}
	
}
