package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Cart;
import com.model.Categories;
import com.model.Products;
import com.model.Status;

public class CartDAOImpl implements CartDAO {
		 

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
	public Status deleteFromCart(int productId) throws SQLException {
		String sql = "delete from cart where product_id = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,productId);
		int res = pst.executeUpdate();

		Status s = new Status();
		if (res != 0) {
			s.setQueryStatus(true);
			return s;
		}
		s.setQueryStatus(false);
		return s;

	}



	@Override
	public Status addToCart(Cart cart) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "insert into cart(product_id,qty, user_id) values(?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
//		pst.setInt(1,cart.getCartId());
		pst.setInt(1,cart.getProductId());
		pst.setInt(2, cart.getQuantity());
		System.out.println("Product Id "+cart.getProductId());
		pst.setInt(3,cart.getUsers().getUserId());
		
		int res = pst.executeUpdate();
		return new Status((res == 1 ) ? true:false);
	}



	@Override
	public List<Products> viewCart(int userId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "Select cr.cart_id , cr.product_id, cr.qty , p.product_id , p.product_name , p.product_price, p.product_image from cart cr join amazon_products p on p.product_id = cr.product_id where user_id = ?";
		PreparedStatement pst = con.prepareStatement(sql);		
		pst.setInt(1, userId );
		
		List<Products> list = new ArrayList<>();
		
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			list.add(new Products(new Cart(rs.getInt(1), rs.getInt(2), rs.getInt(3)), rs.getInt(4), rs.getString(5),rs.getFloat(6),rs.getString(7)));
			
		}
		
		return list;
	}


}
