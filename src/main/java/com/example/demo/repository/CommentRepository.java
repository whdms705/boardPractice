package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment , Long> {

	
	//계층형 댓글 위치를 위한 분기값(jpql로 처리할예정)
	@Query("")
	int  commentGubun();
	

	
}
