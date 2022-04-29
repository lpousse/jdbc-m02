package fr.diginamic.jdbc;

import fr.diginamic.jdbc.dao.Idao;
import fr.diginamic.jdbc.dao.impl.FournisseurIdao;
import fr.diginamic.jdbc.entites.Fournisseur;

public class UseFournisseurIdao {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		/**
		 * Utiliser la classe FournisseurIdao pour afficher la liste des Fournisseurs
		 */
		try {
			FournisseurIdao foi = new  FournisseurIdao();
			getAffiche(foi);
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	/**
	 * methode qui gére un objet de type Idao<Fournisseur>
	 */
	 public static void getAffiche(Idao<Fournisseur> o) {
		 o.extraire().forEach(fo -> System.out.println(fo.getNom()));
	 }
	
}
