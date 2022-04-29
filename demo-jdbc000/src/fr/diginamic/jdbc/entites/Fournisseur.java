package fr.diginamic.jdbc.entites;

public class Fournisseur {
	
	private int id;
	private String nom;

	public Fournisseur() {
		// TODO Auto-generated constructor stub
	}

	public Fournisseur(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
