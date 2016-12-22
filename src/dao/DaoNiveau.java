package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecole.Niveau;

public class DaoNiveau extends Dao implements Idao<Niveau> {

	@Override
	public Niveau find(int id) {
		String sql = "select * from niveaux where code = " + id;
		ResultSet resultats = null;
		Niveau niveau = null;
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			if(resultats.next()){
				niveau = new Niveau(resultats.getString(2), resultats.getInt(1));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return niveau;
	}

	@Override
	public void create(Niveau T) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Niveau T) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Niveau T) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Niveau> findAll() {
		String sql = "select * from niveaux";
		ResultSet resultats = null;
		List<Niveau> liste = new ArrayList<Niveau>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				Niveau niveau = new Niveau(resultats.getString(2), resultats.getInt(1));
				liste.add(niveau);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}
