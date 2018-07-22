package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment , Long> {

	/*SELECT NVL(MIN(SORTS),0) FROM BOARD
	   WHERE  BGROUP = (������ BGROUP)
	   AND SORTS > (������ SORTS)
	   AND DEPTH <= (������ DEPTH)


	��ó: http://vkein.tistory.com/entry/�亯��-�Խ��� [Vkein Programer]
*/	//������ ��� ��ġ�� ���� �бⰪ(jpql�� ó���ҿ���)
	@Query("SELECT COALESCE(MIN(c.sorts),0) FROM Comment c WHERE c.cgroup = ?1 AND c.sorts > ?2 AND c.depth <= ?3")
	Integer  commentGubun(int cgroup,int sorts ,int depth);
	

	
}
