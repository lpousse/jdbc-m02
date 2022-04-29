package proj01.main;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import proj01.main.connexion.ConnectionBdd;

public class app {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conx1=null;
		try {
			conx1 = ConnectionBdd.getConnection();
			
			if(conx1!=null) {
				System.out.println("Base "+conx1.getCatalog()+" connectée !");
			}
			

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
		 if(conx1 != null)
			try {
				conx1.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 
		}
	}
}
