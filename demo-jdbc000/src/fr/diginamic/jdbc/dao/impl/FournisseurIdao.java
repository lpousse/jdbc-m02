package fr.diginamic.jdbc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Fournisseur;

public class FournisseurIdao extends BaseIdao<Fournisseur> {

	public FournisseurIdao() throws Exception {
		super();
	}

	@Override
	protected void finalize() throws Throwable {
		close();
	}
	
	@Override
	public List<Fournisseur> extraire() {
		List<Fournisseur> listeDesFournisseurs = new ArrayList<Fournisseur>();
		try {
			stm = connexion.prepareStatement("SELECT ID, NOM FROM FOURNISSEUR");
			ResultSet curseur = stm.executeQuery();

			while (curseur.next()) {
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"),
						curseur.getString("NOM"));
				listeDesFournisseurs.add(fo);
			}
			curseur.close();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}

		return listeDesFournisseurs;
	}

	@Override
	public void insert(Fournisseur data) {
		try {
			stm = connexion.prepareStatement("INSERT INTO FOURNISSEUR (NOM) VALUES (?)");
			stm.setString(1, data.getNom());
			stm.executeUpdate();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}
	}

	@Override
	public int update(Fournisseur ancienData, Fournisseur nouveauData) {
		int count = -1;
		try {
			stm = connexion.prepareStatement("UPDATE FOURNISSEUR SET NOM = ? WHERE ID = ?");
			stm.setString(1, nouveauData.getNom());
			stm.setInt(2, ancienData.getId());
			count = stm.executeUpdate();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}
		return count;
	}
	
	@Override
	public boolean delete(Fournisseur data) {
		boolean deleted = false;
		try {
			stm = connexion.prepareStatement("DELETE FROM FOURNISSEUR WHERE ID = ?");
			stm.setInt(1, data.getId());
			deleted = stm.executeUpdate() <= 0 ? false : true;
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}
		return deleted;
	}
}
