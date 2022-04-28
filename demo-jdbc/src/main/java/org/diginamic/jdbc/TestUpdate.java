package org.diginamic.jdbc;

import org.diginamic.fr.dao.FournisseurDao;

public class TestUpdate {

	public static void main(String[] args) {
		FournisseurDao.update(4, "La Maison des Peintures");
	}

}
