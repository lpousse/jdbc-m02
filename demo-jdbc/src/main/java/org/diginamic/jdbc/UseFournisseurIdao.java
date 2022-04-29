package org.diginamic.jdbc;

import org.diginamic.fr.models.Fournisseur;
import org.diginamic.jdbc.dao.Idao;
import org.diginamic.jdbc.dao.impl.FournisseurIdao;

public class UseFournisseurIdao {

	public static void main(String[] args) {
		try {
			FournisseurIdao foi = new FournisseurIdao();
			getAffiche(foi);
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void getAffiche(Idao<Fournisseur> o) {
		o.extraire().forEach(fo -> System.out.println(fo.getNom()));
	}
}
