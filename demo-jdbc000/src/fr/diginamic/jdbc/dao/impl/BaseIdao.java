package fr.diginamic.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.diginamic.jdbc.dao.Idao;
import proj01.main.connexion.ConnectionBdd;

public abstract class BaseIdao<T> implements Idao<T> {

	protected Connection connexion = null;
	protected PreparedStatement stm = null;
	
	public BaseIdao() throws Exception {
		connexion = ConnectionBdd.getConnection();
	}

	public void close() throws Exception {
		if (connexion != null && connexion.isClosed() == false) {
			connexion.close();
		}
	}
	
	protected void closeStm() {
		try {
			if (this.stm != null && !this.stm.isClosed()) {
				this.stm.close();
			}
		}
		catch (SQLException ex) {
			System.err.println(ex.getMessage());
		}
	}
}
