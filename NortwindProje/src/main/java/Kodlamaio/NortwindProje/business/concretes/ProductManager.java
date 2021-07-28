package Kodlamaio.NortwindProje.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.NortwindProje.business.abstracts.ProductService;
import Kodlamaio.NortwindProje.core.utilities.results.DataResult;
import Kodlamaio.NortwindProje.core.utilities.results.Result;
import Kodlamaio.NortwindProje.core.utilities.results.SuccessDataResult;
import Kodlamaio.NortwindProje.core.utilities.results.SuccessResult;
import Kodlamaio.NortwindProje.dataAccess.abstracts.ProductDao;
import Kodlamaio.NortwindProje.entities.concretes.Product;
import Kodlamaio.NortwindProje.entities.dtos.ProductWithCategoryDto;


@Service
public class ProductManager implements ProductService{

	
	private ProductDao productDao;
	
	@Autowired 
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}
	@Override
	public DataResult<List<Product>> getAll() {
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(),"Data Listelendi");
				
			
	}
	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Ürün Eklend");
	}
	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"Data Listelendi");
	}
	@Override
	public DataResult<Product> getByProductNameByAndCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameByOrCategoryId(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByCategory_CategoryIdIn(categories),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameContains(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
		return new SuccessDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName,categoryId),"Data Listelendi");
	}
	@Override
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		
		Pageable pageable=PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
	}
	@Override
	public DataResult<List<Product>> getAllSorted(int number) {
		if (number==1) {
			Sort sort =Sort.by(Sort.Direction.DESC,"unitPrice");
			return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
		}
		
			Sort sort =Sort.by(Sort.Direction.ASC,"unitPrice");
		 
		
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
	}
	@Override
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return new SuccessDataResult<List<ProductWithCategoryDto>>(this.productDao.getProductWithCategoryDetails(),"Dto Data Listelendi");
	}

}
