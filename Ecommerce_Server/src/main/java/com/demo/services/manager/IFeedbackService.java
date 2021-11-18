package com.demo.services.manager;

import com.demo.entities.Feedback;
import com.demo.models.FeedbackInfo;

public interface IFeedbackService {

	public Iterable<FeedbackInfo> findAllInfo();
	
	public FeedbackInfo findInfoById(int id);
	
	public Feedback findById(int id);
	
	public FeedbackInfo update(int id, FeedbackInfo feedback);
	
	public void toggleStatus(int id);
	
	public void delete(int id);
	
	public FeedbackInfo add(FeedbackInfo feedback);

}
