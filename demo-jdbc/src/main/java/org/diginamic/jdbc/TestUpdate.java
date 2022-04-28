package org.diginamic.jdbc;

import org.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestUpdate {

	public static void main(String[] args) {
		FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
		dao.update("La Maison de la Peinture", "La Maison des Peintures");
	}

}
