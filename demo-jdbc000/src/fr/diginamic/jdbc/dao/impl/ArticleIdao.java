package fr.diginamic.jdbc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Article;

public class ArticleIdao extends BaseIdao<Article> {

	public ArticleIdao() throws Exception {
		super();
	}

	@Override
	protected void finalize() throws Throwable {
		close();
	}
	
	@Override
	public List<Article> extraire() {
		List<Article> list = new ArrayList<Article>();
		try {
			stm = connexion.prepareStatement("SELECT ID, REF, DESIGNATION, PRIX, ID_FOU FROM ARTICLE");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Article article = new Article(rs.getInt("ID"),	rs.getString("REF"),
						rs.getString("DESIGNATION"), rs.getFloat("PRIX"), rs.getInt("ID_FOU"));
				list.add(article);
			}
			rs.close();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}

		return list;
	}

	@Override
	public void insert(Article data) {
		try {
			stm = connexion.prepareStatement("INSERT INTO ARTICLE (REF, DESIGNATION, PRIX, ID_FOU) VALUES (?, ?, ?, ?)");
			stm.setString(1, data.getRef());
			stm.setString(2, data.getDesignation());
			stm.setFloat(3, data.getPrix());
			stm.setInt(4, data.getIdFou());
			stm.executeUpdate();
		}
		catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}
	}

	@Override
	public int update(Article ancienData, Article nouveauData) {
		int count = -1;
		try {
			stm = connexion.prepareStatement("UPDATE ARTICLE SET REF = ?, DESIGNATION = ?, PRIX = ?, ID_FOU = ? WHERE ID = ?");
			stm.setString(1, nouveauData.getRef());
			stm.setString(2, nouveauData.getDesignation());
			stm.setFloat(3, nouveauData.getPrix());
			stm.setInt(4, nouveauData.getIdFou());
			stm.setInt(5, ancienData.getId());
			count = stm.executeUpdate();
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}
		return count;
	}

	@Override
	public boolean delete(Article data) {
		boolean deleted = false;
		try {
			stm = connexion.prepareStatement("DELETE FROM ARTICLE WHERE ID = ?");
			stm.setInt(1, data.getId());
			deleted = stm.executeUpdate() <= 0 ? false : true;
		}
		catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		finally {
			closeStm();
		}
		return deleted;
	}
}
