package com.demo.repositories.manager;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.entities.Feedback;
import com.demo.entities.Images;
import com.demo.models.BannerInfo;
import com.demo.models.FeedbackInfo;
import com.demo.models.ImageInfo;

public interface IFeedbackRepository extends CrudRepository<Feedback, Integer> {

	@Query("select new com.demo.models.FeedbackInfo(id, users.id, users.username, content, created, status) from Feedback")
	public Iterable<FeedbackInfo> findAllInfo();
	
	@Query("select new com.demo.models.FeedbackInfo(id, users.id, users.username, content, created, status) from Feedback where id = :id")
	public FeedbackInfo findInfoById(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Feedback f set f.status = 1 where f.id = :id")
	public int checkAsDone(@Param("id") int id);
	
	@Modifying
	@Transactional
	@Query("update Feedback f set f.status = CASE f.status WHEN true THEN false ELSE true END WHERE f.id = :id")
	public int toggleStatus(@Param("id") int id);
}
