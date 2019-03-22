package com.iglesia.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

	public ConexionDB() {		
		Connection conn = null;
		try {
			// db parameters
			String url       = "jdbc:mysql://remotemysql.com:3306/T9exh4FqpU";
			String user      = "T9exh4FqpU";
			String password  = "a9eqHcxPj7";

			// create a connection to the database
			conn = DriverManager.getConnection(url, user, password);
			// more processing here
			// ... 
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		finally {
			try{
				if(conn != null) {
					conn.close();
				}
			}catch(SQLException ex){
				System.out.println(ex.getMessage());
			}
		}
	}

}
