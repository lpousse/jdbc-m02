package org.diginamic.jdbc;

import org.diginamic.fr.models.Fournisseur;
import org.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestDelete {

	public static void main(String[] args) {
		FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
		dao.delete(new Fournisseur(4, "La Maison des Peintures"));
	}

}
