package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment , Long> {

	
	//������ ��� ��ġ�� ���� �бⰪ(jpql�� ó���ҿ���)
	@Query("")
	int  commentGubun();
	

	
}
