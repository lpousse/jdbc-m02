package org.diginamic.jdbc;

import java.util.List;

import org.diginamic.fr.models.Fournisseur;
import org.diginamic.jdbc.dao.FournisseurDaoJdbc;

public class TestSelect {

	public static void main(String[] args) {
		FournisseurDaoJdbc dao = new FournisseurDaoJdbc();
		List<Fournisseur> maliste = dao.extraire();
		for (Fournisseur fo: maliste) {
			System.out.println("Id : " + fo.getId() + " Nom : " + fo.getNom());
		}
	}

}
