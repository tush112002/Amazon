package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.Categories;
import com.model.Products;
import com.model.Users;

public class ProductsDAOImpl implements ProductsDAO {

	private static Connection con;

	static {
		try {

			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Products> viewProducts() {

		ArrayList<Products> list = new ArrayList<>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from amazon_products p inner join amazon_categories c on p.category_id = c.category_id ");
			while (rs.next()) {
				list.add(new Products(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getFloat(3), rs.getString(6), new Categories(rs.getInt(7), rs.getString(8))));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}

	@Override
	public Products viewYourProducts(Products products) throws SQLException {
		String sql = "select product_id, product_name, product_price, product_description from amazon_products where user_id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, products.getProductName());
		pst.setInt(2, products.getProductId());
		pst.setFloat(3, products.getProductPrice());
		pst.setString(4, products.getProductDescription());
		pst.setString(5, products.getProductImage());
		ResultSet rs = pst.executeQuery();

		if (rs.next()) {

			products = new Products(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getFloat(3), rs.getString(6), new Categories(rs.getInt(7), rs.getString(8)));
			
			return products;

		}
		return null;
		
	}

	@Override
	public List<Products> filterProducts(int categoryId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from amazon_products where category_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, categoryId);
		ArrayList<Products> list = new ArrayList<>();
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			list.add(new Products(rs.getInt(1), rs.getString(2), rs.getString(4), rs.getFloat(3), rs.getString(6), rs.getInt(5)));
			
		}
		return list;
	}


}
