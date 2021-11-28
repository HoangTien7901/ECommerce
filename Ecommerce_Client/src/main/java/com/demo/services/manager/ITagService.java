package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.TagInfo;

public interface ITagService {

	public ResponseEntity<Iterable<TagInfo>> findAllInfo();
	
	public ResponseEntity<TagInfo> findInfoById(int id);

	public ResponseEntity<TagInfo> create(TagInfo object);
	
	public ResponseEntity<Void> update(TagInfo object);
	
	public ResponseEntity<Void> delete(int id);
}
