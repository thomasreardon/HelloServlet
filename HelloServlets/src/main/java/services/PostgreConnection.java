package services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class PostgreConnection {

	Connection connection;
	String url = "n/a";
	//String url = "jdbc:postgresql://localhost:5432/my_db";
	String user = "n/a";
	String password = "n/a";
	
	
	public Connection dbConnection() throws ClassNotFoundException{
		
		Class.forName("org.postgresql.Driver");
		try {
			connection = DriverManager.getConnection(url, user, password);
			//JOptionPane.showMessageDialog(null, "Connected");
		} catch(SQLException ex) {
			
		Logger.getLogger(PostgreConnection.class.getName()).log(Level.SEVERE, null, ex);
		//JOptionPane.showMessageDialog(null, "Failed to connect.");

		}
		return connection;
		}
}
