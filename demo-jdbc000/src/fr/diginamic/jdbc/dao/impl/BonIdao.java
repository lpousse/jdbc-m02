package fr.diginamic.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.diginamic.jdbc.entites.Bon;

public class BonIdao extends BaseIdao<Bon> {

	public BonIdao() throws Exception {
		super();
	}
	
	@Override
	protected void finalize() throws Throwable {
		close();
	}
	
	@Override
	public List<Bon> extraire() {
		List<Bon> list = new ArrayList<Bon>();
		try {
			stm = connexion.prepareStatement("SELECT ID, NUMERO, DATE_CMDE, DELAI, ID_FOU FROM BON");
			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Bon article = new Bon(rs.getInt("ID"),	rs.getInt("NUMERO"),
						rs.getTimestamp("DATE_CMDE"), rs.getInt("DELAI"), rs.getInt("ID_FOU"));
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
	public void insert(Bon data) {
		try {
			stm = connexion.prepareStatement("INSERT INTO BON (NUMERO, DATE_CMDE, DELAI, ID_FOU) VALUES (?, ?, ?, ?)");
			stm.setInt(1, data.getNumero());
			stm.setTimestamp(2, data.getDateCmde());
			stm.setInt(3, data.getDelai());
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
	public int update(Bon ancienData, Bon nouveauData) {
		int count = -1;
		try {
			stm = connexion.prepareStatement("UPDATE BON SET NUMERO = ?, DATE_CMDE = ?, DELAI = ?, ID_FOU = ? WHERE ID = ?");
			stm.setInt(1, nouveauData.getNumero());
			stm.setTimestamp(2, nouveauData.getDateCmde());
			stm.setInt(3, nouveauData.getDelai());
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
	public boolean delete(Bon data) {
		boolean deleted = false;
		try {
			stm = connexion.prepareStatement("DELETE FROM BON WHERE ID = ?");
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
