package fr.diginamic.jdbc.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;
import fr.diginamic.jdbc.entites.Compo;

public class CompoIdao extends BaseIdao<Compo> {

	public CompoIdao() throws Exception {
		super();
	}
	
	@Override
	protected void finalize() throws Throwable {
		close();
	}
	
	@Override
	public List<Compo> extraire() {
		List<Compo> list = new ArrayList<Compo>();
		try {
			stm = connexion.prepareStatement("SELECT ID, ID_ART, ID_BON, QTE FROM COMPO");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Compo article = new Compo(rs.getInt("ID"),	rs.getInt("ID_ART"),
						rs.getInt("ID_BON"), rs.getInt("QTE"));
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
	public void insert(Compo data) {
		try {
			stm = connexion.prepareStatement("INSERT INTO COMPO (ID_ART, ID_BON, QTE) VALUES (?, ?, ?)");
			stm.setInt(1, data.getIdArt());
			stm.setInt(2, data.getIdBon());
			stm.setInt(3, data.getQte());
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
	public int update(Compo ancienData, Compo nouveauData) {
		int count = -1;
		try {
			stm = connexion.prepareStatement("UPDATE COMPO SET ID_ART = ?, ID_BON = ?, QTE = ? WHERE ID = ?");
			stm.setInt(1, nouveauData.getIdArt());
			stm.setInt(2, nouveauData.getIdBon());
			stm.setInt(3, nouveauData.getQte());
			stm.setInt(4, ancienData.getId());
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
	public boolean delete(Compo data) {
		boolean deleted = false;
		try {
			stm = connexion.prepareStatement("DELETE FROM COMPO WHERE ID = ?");
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
