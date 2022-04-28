package org.diginamic.fr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class TestConnexionJdbc {

	public static void main(String[] args) {
		try {
			System.out.println(TestConnexionJdbc.getConnection().getCatalog());
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
	
	public static Connection getConnection() throws Exception {
		ResourceBundle dbConf = ResourceBundle.getBundle("database");
		
		Class.forName(dbConf.getString("database.driver"));
		return DriverManager.getConnection(dbConf.getString("database.url"), dbConf.getString("database.user"), dbConf.getString("database.password"));
	}
}
