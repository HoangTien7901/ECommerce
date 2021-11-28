package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.BannerInfo;
import com.demo.models.FeedbackInfo;
import com.demo.models.ImageInfo;

public interface IFeedbackService {

	public ResponseEntity<Iterable<FeedbackInfo>> findAllInfo();

	public ResponseEntity<FeedbackInfo> findInfoById(int id);

	public ResponseEntity<FeedbackInfo> create(FeedbackInfo feedback);
	
	public ResponseEntity<Void> update(FeedbackInfo feedback);
	
	public ResponseEntity<Void> delete(int id);
	
	public ResponseEntity<Void> toggleStatus(int id);
}
