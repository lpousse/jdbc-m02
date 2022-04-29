package fr.diginamic.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.dao.impl.ArticleIdao;
import fr.diginamic.jdbc.dao.impl.BonIdao;
import fr.diginamic.jdbc.dao.impl.CompoIdao;
import fr.diginamic.jdbc.dao.impl.FournisseurIdao;
import fr.diginamic.jdbc.entites.Fournisseur;
import proj01.main.connexion.ConnectionBdd;

public class TestSelect {
	
	public static void main(String[] args) {
		try {
			System.out.println("Fournisseurs :");
			FournisseurIdao fidao = new FournisseurIdao();
			fidao.extraire().stream().forEach(f -> System.out.println(f.getNom()));;

			System.out.println("\nArticles :");
			ArticleIdao aidao = new ArticleIdao();
			aidao.extraire().stream().forEach(a -> System.out.println(a.getRef() + " " + a.getDesignation() + " " + a.getPrix() + " " + a.getIdFou()));;
			
			System.out.println("\nBons :");
			BonIdao bidao = new BonIdao();
			bidao.extraire().stream().forEach(b -> System.out.println(b.getNumero() + " " + b.getDateCmde() + " " + b.getDelai() + " " + b.getIdFou()));;
			
			System.out.println("\nCompos :");
			CompoIdao cidao = new CompoIdao();
			cidao.extraire().stream().forEach(c -> System.out.println(c.getIdArt() + " " + c.getIdBon() + " " + c.getQte()));;
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
