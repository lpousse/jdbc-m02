package org.diginamic.jdbc.dao;

import java.util.List;

/**
 * Idao est une interface Générique pour toutes les futures classes de type Idao
 * @author Xeonadow
 *
 * @param <T>
 */
public interface Idao<T> {
	List<T> extraire();
	void insert(T data);
	int update(T ancienObjet, T nouveauObjet);
	boolean delete(T data);
}
