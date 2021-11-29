package com.demo.services.user;

import com.demo.dtos.PaginatesDto;

public interface PaginatesService {

	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage);
}
