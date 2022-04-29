package proj01.main.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionBdd {


	public static Connection getConnection() {
		return ConnectionBdd.getConnection("database");
	}
	
	public static Connection getConnection(String database) {
		try {
			ResourceBundle cont = ResourceBundle.getBundle(database);
			String url = cont.getString("database.url");
			String driver = cont.getString("database.driver");

			String user = cont.getString("database.user");
			String mtp = cont.getString("database.password");
	
			/**
			 * Une première connexion à une BDD
			 */
			Class.forName(driver);
	        return DriverManager.getConnection(url,user,mtp);
		}
		catch(SQLException ex) {
			System.err.println("Erreur SQL : "+ex.getMessage());
		}
		catch(Exception ex) {
			System.err.println("Autres erreurs  : "+ex.getMessage());
		}

			return null;

	}
}
