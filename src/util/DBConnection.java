package util;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class DBConnection {
	public static Connection dbConnect() throws SQLException
	{
		DriverManager.deregisterDriver(new com.mysql.jdbc.Driver());
		
		//Connetion (user,password,url)
		String url="jdbc:mysql://localhost:3306/techtreedb";
		String user="root";
		String password="";
		Connection conn=(Connection) DriverManager.getConnection(url,user,password);
		return conn;
	}
	

}
