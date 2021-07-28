package Kodlamaio.NortwindProje.business.abstracts;
import java.util.List;



import Kodlamaio.NortwindProje.core.utilities.results.DataResult;
import Kodlamaio.NortwindProje.core.utilities.results.Result;
import Kodlamaio.NortwindProje.entities.concretes.Product;
import Kodlamaio.NortwindProje.entities.dtos.ProductWithCategoryDto;

public interface ProductService {
	
	DataResult<List<Product>>  getAll();
	DataResult<List<Product>>  getAll(int pageNo,int pageSize);
	DataResult<List<Product>>  getAllSorted(int number);
	
	Result add(Product product);
	
	DataResult<Product> getByProductName(String productName);

	DataResult<Product> getByProductNameByAndCategoryId(String productName,int categoryId);

	DataResult<List<Product>> getByProductNameByOrCategoryId(String productName,int categoryId);
	DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);
	DataResult<List<Product>> getByProductNameContains(String productName);
	DataResult<List<Product>> getByProductNameStartsWith(String productName);

	DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);
	
	DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();

}
