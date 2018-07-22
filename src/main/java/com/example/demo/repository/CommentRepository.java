package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment , Long> {

	/*SELECT NVL(MIN(SORTS),0) FROM BOARD
	   WHERE  BGROUP = (원글의 BGROUP)
	   AND SORTS > (원글의 SORTS)
	   AND DEPTH <= (원글의 DEPTH)


	출처: http://vkein.tistory.com/entry/답변형-게시판 [Vkein Programer]
*/	//계층형 댓글 위치를 위한 분기값(jpql로 처리할예정)
	@Query("SELECT COALESCE(MIN(c.sorts),0) FROM Comment c WHERE c.cgroup = ?1 AND c.sorts > ?2 AND c.depth <= ?3")
	Integer  commentGubun(int cgroup,int sorts ,int depth);
	

	
}
