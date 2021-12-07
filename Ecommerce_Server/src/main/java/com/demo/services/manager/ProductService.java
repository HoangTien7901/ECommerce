package com.demo.services.manager;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entities.Products;
import com.demo.models.ProductInfo;
import com.demo.repositories.manager.IBranchRepository;
import com.demo.repositories.manager.ICategoryRepository;
import com.demo.repositories.manager.IProductRepository;
import com.demo.repositories.manager.IStoreRepository;

@Service("product")
public class ProductService implements IProductService {

	@Autowired
	private IProductRepository repos;
	
	@Autowired
	private IStoreRepository storeRepos;
	
	@Autowired
	private IBranchRepository branchRepos;
	
	@Autowired
	private ICategoryRepository categoryRepos;

	@Override
	public Iterable<ProductInfo> findAllInfo() {
		return repos.findAllInfo();
	}
	
	@Override
	public Iterable<ProductInfo> findAllActive() {
		return repos.findAllInfoActive();
	}

	@Override
	public Iterable<ProductInfo> findBestSellingProducts() {
		return repos.findBestSellingProducts();
	}

	@Override
	public Iterable<ProductInfo> findOutStandingProducts() {
		return repos.findOutStandingProducts();
	}
	
	@Override
	public Iterable<ProductInfo> searchWithCategory(String keyword, double min, double max, int categoryId) {
		return repos.searchWithCategory(keyword, min, max, categoryId);
	}

	@Override
	public Iterable<ProductInfo> search(String keyword, double min, double max) {
		return repos.search(keyword, min, max);
	}

	@Override
	public ProductInfo findInfoById(int id) {
		return repos.findInfoById(id);
	}

	@Override
	public Products findById(int id) {
		return repos.findById(id).get();
	}

	@Override
	public ProductInfo add(ProductInfo _object) {

		Products object = new Products();
		object.setName(_object.getName());
		
		object.setBranchs(branchRepos.findById(_object.getBranchId()).get());
		object.setCategories(categoryRepos.findById(_object.getCategoryId()).get());
		object.setStores(storeRepos.findById(1).get());

		object.setAvatar(_object.getAvatar());
		
		object.setPrice(_object.getPrice());
		object.setOriginalPrice(_object.getOriginalPrice());
		
		object.setDescription(_object.getDescription());
		object.setDescriptionDetail(_object.getDescriptionDetail());
		object.setCreated(new Date());

		object.setIsOutstanding(_object.getIsOutstanding());
		object.setIsBestSelling(_object.getIsBestSelling());
		object.setIsNew(_object.getIsNewProduct());
		
		object.setSaleOffPercent(_object.getSaleOffPercent());
		
		object.setStatus(_object.isStatus());
		if (_object.isStatus()) {
			object.setBanReason(null);
		} else {
			object.setBanReason(_object.getBanReason());
		}
		
		object = repos.save(object);
		
		return repos.findInfoById(object.getId());
	}
	
	@Override
	public ProductInfo update(int id, ProductInfo _object) {

		Products object = repos.findById(id).get();
		object.setName(_object.getName());
		
		object.setBranchs(branchRepos.findById(_object.getBranchId()).get());
		object.setCategories(categoryRepos.findById(_object.getCategoryId()).get());
		object.setStores(storeRepos.findById(_object.getStoreId()).get());

		object.setAvatar(_object.getAvatar());
		
		object.setDescription(_object.getDescription());
		object.setDescriptionDetail(_object.getDescriptionDetail());
		object.setUpdated(new Date());

		object.setPrice(_object.getPrice());
		object.setOriginalPrice(_object.getOriginalPrice());
		
		object.setIsOutstanding(_object.getIsOutstanding());
		object.setIsBestSelling(_object.getIsBestSelling());
		object.setIsNew(_object.getIsNewProduct());
		
		object.setSaleOffPercent(_object.getSaleOffPercent());
		
		object.setStatus(_object.isStatus());
		if (_object.isStatus()) {
			object.setBanReason(null);
		} else {
			object.setBanReason(_object.getBanReason());
		}
		
		object = repos.save(object);
		
		return repos.findInfoById(id);
	}

	@Override
	public void delete(int id) {
		repos.delete(repos.findById(id).get());
	}
	
	@Override
	public int toggleStatus(int id) {
		return repos.toggleStatus(id, new Date());
	}

	@Override
	public int updateBanReason(int id, String banReason) {
		return repos.updateBanReason(id, banReason);
	}
}
