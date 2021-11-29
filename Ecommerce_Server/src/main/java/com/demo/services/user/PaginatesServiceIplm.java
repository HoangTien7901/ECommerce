package com.demo.services.user;

import org.springframework.stereotype.Service;

import com.demo.dtos.PaginatesDto;

@Service("paginatesService")
public class PaginatesServiceIplm implements PaginatesService {

	@Override
	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage) {
		PaginatesDto paginate = new PaginatesDto();
		paginate.setLimit(limit);
		paginate.setTotalPage(setInfoTotalPage(totalData, limit));
		paginate.setCurentPage(checkCurrentPage(currentPage, paginate.getTotalPage()));
		paginate.setStart(findStart(paginate.getCurentPage(), limit));
		paginate.setEnd(findEnd(paginate.getStart(), limit, totalData));
		return paginate;
	}
	
	private int findEnd(int start, int limit, int totalData) {		 
		 return start + limit > totalData ? totalData : (start + limit) -1;
	 }
	
	private int findStart(int currentPage, int limit) {		 
		 return ((currentPage - 1) * limit) + 1;
	 }	

	private int setInfoTotalPage(int totalData, int limit) {
		int totalPage = totalData / limit;
		totalPage = totalPage * limit < totalData ? totalPage + 1 : totalPage;
		return totalPage;
	}
	 private int checkCurrentPage(int currentPage, int totalPage) {
		 if(currentPage < 1) {
			 return 1;
		 }
		 if(currentPage > totalPage) {
			 return totalPage;
		 }
		 return currentPage;
	 }

}
