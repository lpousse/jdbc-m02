package org.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.models.Fournisseur;
import org.diginamic.jdbc.dao.Idao;

public class FournisseurIdao implements Idao<Fournisseur> {

	private Connection connexion = null;

	public FournisseurIdao() throws Exception {
		this.connexion = TestConnexionJdbc.getConnection();
	}

	public void close() throws Exception {
		if (connexion != null && connexion.isClosed() == false) {
			connexion.close();
		}
	}

	@Override
	protected void finalize() throws Throwable {
		close();
	}

	@Override
	public List<Fournisseur> extraire() {
		List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
		try {
			PreparedStatement stat = connexion.prepareStatement("SELECT ID, NOM FROM FOURNISSEUR");
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
				listeDesFournisseurs.add(fo);
			}
			curseur.close();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

		return listeDesFournisseurs;
	}

	@Override
	public void insert(Fournisseur data) {
		// TODO Auto-generated method stub

	}

	@Override
	public int update(Fournisseur ancienObjet, Fournisseur nouveauObjet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Fournisseur data) {
		// TODO Auto-generated method stub
		return false;
	}

}
