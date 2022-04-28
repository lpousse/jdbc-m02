package org.diginamic.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.models.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	public List<Fournisseur> extraire() {
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
	
	public void insert(Fournisseur fournisseur) {
		Connection connection = null;
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			state.executeUpdate("INSERT INTO FOURNISSEUR VALUES ('" + fournisseur.getId() + "', '" + fournisseur.getNom() + "')");
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
	
	public int update(String ancienNom, String nouveauNom) {
		Connection connection = null;
		int count = -1;
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			count = state.executeUpdate("UPDATE FOURNISSEUR SET NOM = '" + nouveauNom  + "' WHERE NOM = '" + ancienNom + "'");
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
	
	public boolean delete(Fournisseur fournisseur) {
		Connection connection = null;
		boolean deleted = false;
		try {
			connection = TestConnexionJdbc.getConnection();
			Statement state = connection.createStatement();
			deleted = state.executeUpdate("DELETE FROM FOURNISSEUR WHERE ID = " + fournisseur.getId()) <= 0 ? false : true;
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
		return deleted;
	}
}
