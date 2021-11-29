package com.demo.dtos;

public class PaginatesDto {
	private int curentPage, limit, start, end, totalPage;	

	public PaginatesDto() {
		super();
	}

	public PaginatesDto(int curentPage, int limit, int start, int end, int totalPage) {
		super();
		this.curentPage = curentPage;
		this.limit = limit;
		this.start = start;
		this.end = end;
		this.totalPage = totalPage;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	

}
