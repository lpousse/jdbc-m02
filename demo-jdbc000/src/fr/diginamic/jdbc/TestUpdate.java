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

public class TestUpdate {
	
	public static void main(String[] args) {
		try {
			System.out.println("Fournisseurs :");
			FournisseurIdao fidao = new FournisseurIdao();
			Fournisseur oldObj = new Fournisseur(4, "La Maison des Peintures");
			Fournisseur newObj = new Fournisseur(4, "La Maison des Peinture");
			
			fidao.update(oldObj, newObj);
			fidao.extraire().stream().forEach(f -> System.out.println(f.getNom()));;
			fidao.update(newObj, oldObj);
			fidao.extraire().stream().forEach(f -> System.out.println(f.getNom()));;
			
			System.out.println("\nArticles :");
			ArticleIdao aidao = new ArticleIdao();
			Article oldArticle = new Article(11, "G01", "Peinture blanche 1L", 12.5f, 4);
			Article newArticle = new Article(11, "G01", "Peinture noire 1L", 12.5f, 4);

			aidao.update(oldArticle, newArticle);
			aidao.extraire().stream().forEach(a -> System.out.println(a.getRef() + " " + a.getDesignation() + " " + a.getPrix() + " " + a.getIdFou()));;
			aidao.update(newArticle, oldArticle);
			aidao.extraire().stream().forEach(a -> System.out.println(a.getRef() + " " + a.getDesignation() + " " + a.getPrix() + " " + a.getIdFou()));;
			
			System.out.println("\nBons :");
			BonIdao bidao = new BonIdao();
			Bon oldBon = new Bon(7, 7, Timestamp.valueOf(LocalDateTime.now()), 1, 4);
			Bon newBon = new Bon(7, 7, Timestamp.valueOf(LocalDateTime.now()), 3, 4);
			
			bidao.update(oldBon, newBon);
			bidao.extraire().stream().forEach(b -> System.out.println(b.getNumero() + " " + b.getDateCmde() + " " + b.getDelai() + " " + b.getIdFou()));;
			bidao.update(newBon, oldBon);
			bidao.extraire().stream().forEach(b -> System.out.println(b.getNumero() + " " + b.getDateCmde() + " " + b.getDelai() + " " + b.getIdFou()));;
			
			System.out.println("\nCompos :");
			CompoIdao cidao = new CompoIdao();
			Compo oldCompo = new Compo(17, 2, 7, 3);
			Compo newCompo = new Compo(17, 2, 7, 5);
			
			cidao.update(oldCompo, newCompo);
			cidao.extraire().stream().forEach(c -> System.out.println(c.getIdArt() + " " + c.getIdBon() + " " + c.getQte()));;
			cidao.update(newCompo, oldCompo);
			cidao.extraire().stream().forEach(c -> System.out.println(c.getIdArt() + " " + c.getIdBon() + " " + c.getQte()));;
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
