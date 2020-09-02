package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	public static Connection getConnection()
	{
		Connection dbcon=null;
		try {
			dbcon=DriverManager.getConnection("jdbc:mysql://localhost/newspaperproject","root","");
			/* System.out.println("Connection Successful"); */
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dbcon;
	}
	
	/*
	 * public static void main(String arrgs[]) { Connection ref=getConnection();
	 * if(ref==null) { System.out.println("error"); } else
	 * System.out.println("Success"); }
	 */

}
