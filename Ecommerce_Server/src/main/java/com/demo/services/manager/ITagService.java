package com.demo.services.manager;

import com.demo.entities.Tags;
import com.demo.models.TagInfo;

public interface ITagService {

	public Iterable<TagInfo> findAllInfo();
	
	public Iterable<TagInfo> findAllActiveInfo();
	
	public TagInfo findInfoById(int id);
	
	public Tags findById(int id);
	
	public TagInfo update(int id, TagInfo object);
	
	public void delete(int id);
	
	public TagInfo add(TagInfo object);

}
