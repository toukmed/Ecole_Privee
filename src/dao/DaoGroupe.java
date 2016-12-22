package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecole.Groupe;
import ecole.Niveau;
import ecole.Groupe;


public class DaoGroupe extends Dao implements Idao<Groupe> {

	@Override
	public Groupe find(int id) {
		String sql = "select * from groupes where id = " + id;
		ResultSet resultats = null;
		Groupe groupe = null;
		DaoNiveau managerNiveau = new DaoNiveau();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			if(resultats.next()){
				//int code,String libelle,Niveau niveau
				groupe = new Groupe( resultats.getInt(1),resultats.getString(2),managerNiveau.find(resultats.getInt(3)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return groupe;
	}

	@Override
	public void create(Groupe T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Groupe T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Groupe T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Groupe> findAll() {
		String sql = "select * from groupes";
		ResultSet resultats = null;
		DaoNiveau daoniveau = new DaoNiveau();
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				Groupe groupe = new Groupe(resultats.getInt(1), resultats.getString(2), daoniveau.find(resultats.getInt(3)));
				liste.add(groupe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}
	public List<Groupe> findByNiveau(int idNiveau){
		String sql = "select * from groupes where niveau = " + idNiveau;
		ResultSet resultats = null;
		DaoNiveau daoniveau = new DaoNiveau();
		List<Groupe> liste = new ArrayList<Groupe>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				Groupe groupe = new Groupe(resultats.getInt(1), resultats.getString(2), daoniveau.find(resultats.getInt(3)));
				liste.add(groupe);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
		
	}

}
