package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.BannerInfo;
import com.demo.models.CategoryInfo;
import com.demo.models.FeedbackInfo;
import com.demo.models.ImageInfo;

public interface ICategoryService {

	public ResponseEntity<Iterable<CategoryInfo>> findAllInfo();
	
	public ResponseEntity<Iterable<CategoryInfo>> findAllExcept(int id, int level);

	public ResponseEntity<CategoryInfo> findInfoById(int id);

	public ResponseEntity<CategoryInfo> create(CategoryInfo object);
	
	public ResponseEntity<Void> update(CategoryInfo object);
	
	public ResponseEntity<Void> delete(int id);
}
