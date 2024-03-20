package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.PathParam;

import com.model.Cart;
import com.model.Products;
import com.model.Status;

public interface CartDAO {

	public Status addToCart(Cart cart) throws SQLException;
	public Status deleteFromCart(int userId) throws SQLException;
//	public ArrayList<Products> viewCart(Cart cart,int userId) throws SQLException;
	public List<Products> viewCart(int userId) throws SQLException;
}
