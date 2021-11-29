package com.demo.services.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Branchs;
import com.demo.entities.Tags;
import com.demo.models.BranchInfo;
import com.demo.models.TagInfo;
import com.demo.repositories.manager.IBranchRepository;
import com.demo.repositories.manager.ITagRepository;

@Service("branch")
public class BranchService implements IBranchService {

	@Autowired
	private IBranchRepository repos;

	@Override
	public Iterable<BranchInfo> findAllInfo() {
		return repos.findAllInfo();
	}

	@Override
	public BranchInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Branchs findById(int id) {
		return repos.findById(id).get();
	}

	@Override
	public BranchInfo update(int id, BranchInfo _object) {

		Branchs object = repos.findById(id).get();

		object.setName(_object.getName());
		object.setLogo(_object.getLogo());

		object = repos.save(object);

		return repos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}

	@Override
	public BranchInfo add(BranchInfo _object) {

		Branchs object = new Branchs();

		object.setName(_object.getName());
		object.setLogo(_object.getLogo());

		object = repos.save(object);

		return repos.findInfoById(object.getId());
	}
}
