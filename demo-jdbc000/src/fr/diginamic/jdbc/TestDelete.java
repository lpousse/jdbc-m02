package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import fr.diginamic.jdbc.dao.impl.ArticleIdao;
import fr.diginamic.jdbc.dao.impl.BonIdao;
import fr.diginamic.jdbc.dao.impl.CompoIdao;
import fr.diginamic.jdbc.dao.impl.FournisseurIdao;
import fr.diginamic.jdbc.entites.Article;
import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;
import fr.diginamic.jdbc.entites.Fournisseur;
import proj01.main.connexion.ConnectionBdd;

public class TestDelete {
	
	public static void main(String[] args) {
		try {
			FournisseurIdao fidao = new FournisseurIdao();
			fidao.delete(new Fournisseur(5, "Leroy Merlin"));
			
			ArticleIdao aidao = new ArticleIdao();
			aidao.delete(new Article(11, "G01", "Peinture blanche 1L", 12.5f, 4));
			
			BonIdao bidao = new BonIdao();
			bidao.insert(new Bon(7, 7, Timestamp.valueOf(LocalDateTime.now()), 1, 4));
			
			CompoIdao cidao = new CompoIdao();
			cidao.insert(new Compo(17, 2, 7, 3));
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
