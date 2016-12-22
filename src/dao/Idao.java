package dao;

import java.sql.ResultSet;
import java.util.List;

import ecole.Personne;

public interface Idao<T> {
	public T find(int id);
	public void create(T T);
	public void delete(T T);
	public void update(T T);
	public List<T> findAll();
}
