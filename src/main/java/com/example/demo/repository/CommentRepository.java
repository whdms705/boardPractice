package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment , Long> {

	/*SELECT NVL(MIN(SORTS),0) FROM BOARD
	   WHERE  BGROUP = (������ BGROUP)
	   AND SORTS > (������ SORTS)
	   AND DEPTH <= (������ DEPTH)
	   
*/	//������ ��� ��ġ�� ���� �бⰪ(jpql�� ó���ҿ���)
	@Query("SELECT COALESCE(MIN(c.sorts),0) FROM Comment c WHERE c.cgroup = ?1 AND c.sorts > ?2 AND c.depth <= ?3")
	Integer  commentGubun(int cgroup,int sorts ,int depth);
	
	/*3. SELECT NVL(MAX(SORTS),0) + 1 FROM BOARD 
    WHERE BGROUP = (������ BGROUP);*/
	
	@Query("SELECT COALESCE(MIN(c.sorts),0)+1 FROM Comment c where c.cgroup = ?1")
	Integer sortsValue(int cgroup);
	
	/*UPDATE BOARD SET SORTS = SORTS + 1 
			  WHERE BGROUP =  (������ BGROUP)  AND SORTS >= (1����)*/

	@Query("UPDATE Comment c SET c.sorts = c.sorts + 1 WHERE c.cgroup = ?1 AND c.sorts >=?2 ")
	void updateSorts(int cgroup,int gubun);
	
}
