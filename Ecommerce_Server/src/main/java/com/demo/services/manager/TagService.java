package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Tags;
import com.demo.models.TagInfo;
import com.demo.repositories.manager.ITagRepository;

@Service("tag")
public class TagService implements ITagService {

	@Autowired
	private ITagRepository repos;

	@Override
	public Iterable<TagInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public Iterable<TagInfo> findAllActiveInfo() {
		return repos.findAllActiveInfo();
	}

	@Override
	public TagInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Tags findById(int id) {
		return repos.findById(id).get();
	}

	@Override
	public TagInfo update(int id, TagInfo _object) {

		Tags object = repos.findById(id).get();

		object.setName(_object.getName());
		object.setStatus(_object.isStatus());

		object = repos.save(object);

		return repos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}

	@Override
	public TagInfo add(TagInfo _object) {

		Tags object = new Tags();

		object.setName(_object.getName());
		object.setStatus(_object.isStatus());

		object = repos.save(object);

		return repos.findInfoById(object.getId());
	}
}
