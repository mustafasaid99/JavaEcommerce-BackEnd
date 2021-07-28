package Kodlamaio.NortwindProje.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlamaio.NortwindProje.business.abstracts.ProductService;
import Kodlamaio.NortwindProje.core.utilities.results.DataResult;
import Kodlamaio.NortwindProje.core.utilities.results.Result;
import Kodlamaio.NortwindProje.entities.concretes.Product;
import Kodlamaio.NortwindProje.entities.dtos.ProductWithCategoryDto;
@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;
	
	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}


	@GetMapping("/getall")
	public DataResult<List<Product>> getAll(){
		return this.productService.getAll();
		
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		
		return this.productService.add(product);
		
	}
	 @GetMapping("/getByProductName")
	 public DataResult<Product> getByProductName(@RequestParam String productName){
		 
		 return this.productService.getByProductName(productName);
		 
	 }
	 @GetMapping("/getByProductNameAndCategory")
	public DataResult<Product> getByProductNameByAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
		
		return this.productService.getByProductNameByAndCategoryId(productName, categoryId);
	}
	 @GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
	return this.productService.getByProductNameContains(productName);	
	}
	 @GetMapping("/getAllByPage")
	 public DataResult<List<Product>> getAll(int pageNo,int pageSize){
		 return this.productService.getAll(pageNo, pageSize);
	 }
	 @GetMapping("/getAllSort")
		public DataResult<List<Product>> getAllSorted(@RequestParam int number){
			
			return this.productService.getAllSorted(number);
		}
	 
	 @GetMapping("/getByProductNameByOrCategoryId")
	 public DataResult<List<Product>> getByProductNameByOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId){
		 
		 return this.productService.getByProductNameByOrCategoryId(productName, categoryId);
	 }
	 
	 @GetMapping("/getByProductNameStartsWith")
	 public DataResult<List<Product>> getByProductNameStartsWith(String productName){
		 
		 return this.productService.getByProductNameStartsWith(productName);
	 }
	 @GetMapping("/getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId){
		return this.productService.getByNameAndCategory(productName,categoryId);
		
	}
	 @GetMapping("/getProductWithCategoryDetails")
	 public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
		 
		 return this.productService.getProductWithCategoryDetails();
	 }
	
}
