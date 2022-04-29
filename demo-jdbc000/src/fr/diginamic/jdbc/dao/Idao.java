package fr.diginamic.jdbc.dao;

import java.util.List;
/**
 * 
 * Idao est une interface Générique pour toutes les futures classes de type Idao
 * @author chris
 *
 * @param <T>
 */

public interface Idao<T> {
	List<T> extraire();
	void insert(T data);
	int update(T ancienData , T nouveauData);
	boolean delete(T data);	

}
