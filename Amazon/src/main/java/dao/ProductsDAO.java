package dao;

import com.model.Categories;
import com.model.Products;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ProductsDAO {

	public List<Products> viewProducts();
	
	public List<Products> filterProducts(int categoryId) throws SQLException;

	Products viewYourProducts(Products products) throws SQLException;

//	List<Products> filterProducts(Categories cat) throws SQLException;
	
}
