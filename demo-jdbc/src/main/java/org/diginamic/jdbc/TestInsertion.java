package org.diginamic.jdbc;

import org.diginamic.fr.models.Fournisseur;
import org.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestInsertion {

	public static void main(String[] args) {
		FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
		dao.insert(new Fournisseur(4, "La Maison de la Peinture"));
	}

}
