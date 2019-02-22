package services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;

import org.mindrot.jbcrypt.BCrypt;

import models.ErsUser;

public class LoginService {

	public void getSalt(ErsUser user, String email) {
		 PostgreConnection conn = new PostgreConnection();
		try {
			conn.dbConnection();
    		PreparedStatement pstmt = conn.connection.prepareStatement("SELECT * FROM ers_users WHERE email = ?");
    		pstmt.setString(1, email);
    		ResultSet rs = pstmt.executeQuery();
    		while(rs.next()){
    			if(rs.getString("email").equals(email)) {
    				user.setPwSalt((rs.getString("pw_salt")));
    			}
	}
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
    			
	public void signIn(ErsUser user, String email, String password) {
		 PostgreConnection conn = new PostgreConnection();
		// String newSalt = BCrypt.gensalt();
		 
			try {
				//get salt from users table by the given username
				//re encrypt using the entered password and the retrieved salt
				//String hashedPw ="";
				//String salt = login.getSalt(username);
			//	System.out.println(user.getPwSalt());
				//System.out.println(password);
				String hashedPW = BCrypt.hashpw(password, user.getPwSalt());
				//System.out.println(hashedPW);
				conn.dbConnection();
	    		PreparedStatement pstmt = conn.connection.prepareStatement("SELECT * FROM ers_users WHERE email = ?");
	    		pstmt.setString(1, email);
	    		ResultSet rs = pstmt.executeQuery();
	    		while(rs.next()){
	    			
	    			if(rs.getString("email").equals(email) && rs.getString("password").equals(hashedPW)) {
	    				user.setId(rs.getInt("id"));
	    				//System.out.println(rs.getInt("id"));
	    				user.setRoleId(rs.getInt("user_role"));
	    				//user.setSalt(rs.getString("pw_salt"));
	    			}
				}
			}
	    		catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
		            System.out.println(e.getMessage());
		        } catch (NullPointerException e) {
		        	e.printStackTrace();
		        }
		
	}
		
}
