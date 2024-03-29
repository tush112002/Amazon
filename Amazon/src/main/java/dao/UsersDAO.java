package dao;

import java.sql.SQLException;
import java.util.List;

import com.model.Status;
import com.model.Users;

public interface UsersDAO {
	public Status signUp(Users user) throws SQLException;

	public Users signIn(Users user) throws SQLException;

//	public Users viewProfile(Users user) throws SQLException;	

	public Status updateProfile(Users user) throws SQLException;

	public Users  viewProfile(int userId) throws SQLException;
}
