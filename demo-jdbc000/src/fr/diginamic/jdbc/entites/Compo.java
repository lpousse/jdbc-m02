package fr.diginamic.jdbc.entites;

public class Compo {

	int id;
	int idArt;
	int idBon;
	int qte;
	
	public Compo() {
		super();
	}

	public Compo(int id, int idArt, int idBon, int qte) {
		super();
		this.id = id;
		this.idArt = idArt;
		this.idBon = idBon;
		this.qte = qte;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdArt() {
		return idArt;
	}

	public void setIdArt(int idArt) {
		this.idArt = idArt;
	}

	public int getIdBon() {
		return idBon;
	}

	public void setIdBon(int idBon) {
		this.idBon = idBon;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}
	
}
