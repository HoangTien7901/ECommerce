package com.demo.services.manager;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Banners;
import com.demo.entities.Feedback;
import com.demo.entities.Images;
import com.demo.entities.Users;
import com.demo.models.FeedbackInfo;
import com.demo.models.ImageInfo;
import com.demo.repositories.manager.IBannerRepository;
import com.demo.repositories.manager.IFeedbackRepository;
import com.demo.repositories.manager.IImageRepository;
import com.demo.repositories.manager.IUserRepository;

@Service("feedback")
public class FeedbackService implements IFeedbackService {

	@Autowired
	private IFeedbackRepository feedbackRepos;
	
	@Autowired
	private IUserRepository userRepos;

	@Override
	public Iterable<FeedbackInfo> findAllInfo() {
		return feedbackRepos.findAllInfo();
	}

	@Override
	public FeedbackInfo findInfoById(int id) {
		return feedbackRepos.findInfoById(id);
	}

	@Override
	public Feedback findById(int id) {
		// TODO Auto-generated method stub
		return feedbackRepos.findById(id).get();
	}
	
	@Override
	public void toggleStatus(int id) {
		try {
			feedbackRepos.toggleStatus(id);
		} catch (Exception e) {
			System.out.println("Server - feedback update error: " + e.getMessage());
		}
	}

	@Override
	public FeedbackInfo add(FeedbackInfo feedbackInfo) {
		Feedback feedback = new Feedback();
		feedback.setContent(feedbackInfo.getContent());
		feedback.setCreated(new Date());
		
		Users user = userRepos.findById(feedbackInfo.getUserId()).get();
		feedback.setUsers(user);
		feedback.setStatus(false);
		
		feedbackRepos.save(feedback);
		
		return feedbackRepos.findInfoById(feedbackInfo.getId());
	}

	@Override 
	public FeedbackInfo update(int id, FeedbackInfo feedbackInfo) 
	{ 
		Feedback feedback = feedbackRepos.findById(id).get();
		feedback.setContent(feedbackInfo.getContent());
		
		Users user = userRepos.findById(feedbackInfo.getUserId()).get();
		
		feedback.setUsers(user);
		feedback.setStatus(feedbackInfo.isStatus());
		
		feedbackRepos.save(feedback);
		
		return feedbackRepos.findInfoById(id); 
	}

	@Override
	public void delete(int id) {
		feedbackRepos.delete(feedbackRepos.findById(id).get());
	}	
}
