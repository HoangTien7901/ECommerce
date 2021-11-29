package com.demo.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.models.BranchInfo;
import com.demo.services.user.*;

@RestController
@RequestMapping("/api/branch")
public class BranchRestController {

	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "findall", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<BranchInfo>> findAll() {
		try {
			return new ResponseEntity<Iterable<BranchInfo>>(branchService.findAll(), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<Iterable<BranchInfo>>(HttpStatus.BAD_REQUEST);
		}
	}	
	
	@RequestMapping(value = "find/{id}", method = RequestMethod.GET, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
	public ResponseEntity<BranchInfo> find(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<BranchInfo>(branchService.find(id), HttpStatus.OK);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<BranchInfo>(HttpStatus.BAD_REQUEST);
		}
	}	

}
