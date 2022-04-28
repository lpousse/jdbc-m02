package org.diginamic.jdbc;

import java.util.List;

import org.diginamic.fr.dao.FournisseurDao;
import org.diginamic.fr.models.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		List<Fournisseur> maliste = FournisseurDao.getAll();
		for (Fournisseur fo: maliste) {
			System.out.println("Id : " + fo.getId() + " Nom : " + fo.getNom());
		}
	}

}
