package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Products;
import com.model.Status;
import com.model.Users;

public class UsersDAOImpl implements UsersDAO {

	private Connection connection;

	public UsersDAOImpl() {
		connection = DBUtil.getConnection();
		System.out.println("User impl's connection= " + connection.hashCode());
	}

	@Override
	public Status signUp(Users user) throws SQLException {
		String sql = "insert into amazon_users (user_name,user_email,user_password, user_address, user_mobile) values(?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getUserEmail());
		pst.setString(3, user.getUserPassword());
		pst.setString(4, user.getUserAddress());
		pst.setString(5, user.getUserMobile());
		pst.executeUpdate();
		Status s = new Status();
		s.setQueryStatus(true);
		return s;
	}

	@Override
	public Users signIn(Users user) throws SQLException {
		String sql = "SELECT * FROM amazon_users WHERE user_email = ? AND user_password = ?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setString(1, user.getUserEmail());
		pst.setString(2, user.getUserPassword()); 

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			user = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
					rs.getString(6));
			return user;
		}

		return null;
	}


	@Override
	public Users viewProfile(int userId) throws SQLException {
		String sql = "SELECT * FROM amazon_users WHERE user_id =?";
		PreparedStatement pst = connection.prepareStatement(sql);
		pst.setInt(1, userId);
		ResultSet rs = pst.executeQuery();
		
//		List<Users> list = new ArrayList<>();

		if (rs.next()) {

			Users users = new Users(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6),
					rs.getString(5),rs.getString(7));
			
			return users;

		}
		return null;
	}

	@Override
	public Status updateProfile(Users user) throws SQLException {
		
		String sql = "Update amazon_users SET user_name=? ,user_email=?,user_mobile=?, user_address=? where user_id=?";
		PreparedStatement pst = connection.prepareStatement(sql);

		pst.setString(1, user.getUserName());
		pst.setString(2, user.getUserEmail());	
		pst.setString(3, user.getUserMobile());
		pst.setString(4, user.getUserAddress());
		pst.setInt(5, user.getUserId());
		int res = pst.executeUpdate();

		return new Status((res == 1) ? true : false);
	}


}
