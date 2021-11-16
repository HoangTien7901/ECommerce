package com.demo.services.manager;

import org.springframework.http.ResponseEntity;

import com.demo.models.BannerInfo;

public interface IBannerService {

	public ResponseEntity<Iterable<BannerInfo>> findAllInfo();

	public ResponseEntity<BannerInfo> findInfoById(int id);

	public ResponseEntity<Void> update(BannerInfo banner);
}
