package org.diginamic.fr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.models.Fournisseur;

/**
 * Cette classe va me permettre de lire en JDBC la table Fournisseur, d'avoir les méthodes CRUD
 * et d'obtenir des objets de type Fournisseur
 * @author Xeonadow
 *
 */
public class FournisseurDao {
	/**
	 * Retourne la lsite des Fournisseurs de ma base de donnée
	 * @return
	 */
	public static List<Fournisseur> getAll() {
		Connection connection = null;
		List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			ResultSet curseur = state.executeQuery("SELECT * FROM FOURNISSEUR");
			while(curseur.next()) {
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
				listeDesFournisseurs.add(fo);
			}
			curseur.close();
			state.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null)
					connection.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		return listeDesFournisseurs;
	}
	
	public static Integer count() {
		Connection connection = null;
		Integer count = null;
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			ResultSet resultSet = state.executeQuery("SELECT COUNT(*) AS count FROM FOURNISSEUR");
			resultSet.next();
			count = resultSet.getInt("count");
			resultSet.close();
			state.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null)
					connection.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		return count;
	}
	
	public static void insert(String nom) {
		Connection connection = null;
		Integer count = FournisseurDao.count();
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			state.executeUpdate("INSERT INTO FOURNISSEUR VALUES ('" + (count + 1) + "', '" + nom  + "')");
			state.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null)
					connection.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void update(Integer id, String nouveauNom) {
		Connection connection = null;
		Integer count = FournisseurDao.count();
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			state.executeUpdate("UPDATE FOURNISSEUR SET NOM = '" + nouveauNom  + "' WHERE ID = " + id);
			state.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null)
					connection.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
	
	public static void delete(Integer id) {
		Connection connection = null;
		Integer count = FournisseurDao.count();
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			state.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID = " + id);
			state.close();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			try {
				if(connection != null)
					connection.close();
			}
			catch(Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}
}
