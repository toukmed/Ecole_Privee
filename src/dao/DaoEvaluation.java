package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecole.Evaluation;
import ecole.Niveau;

public class DaoEvaluation extends Dao implements Idao<Evaluation>{

	@Override
	public Evaluation find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Evaluation ev) {
		String sql = "insert into Evatuation (note,matiere,enseignant) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setDouble(1,  ev.getNote());
			stmt.setInt(2, ev.getMatiere().getId_matiere());
			stmt.setInt(3, ev.getEnseignant().getId());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Evaluation ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Evaluation ev) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Evaluation> findAll() {
		String sql = "select * from Evaluation";
		ResultSet resultats = null;
		List<Evaluation> liste = new ArrayList<Evaluation>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				//Evaluation niveau = new Evaluation(resultats.getDouble(1), resultats.getInt(2), resultats.getInt(3));
				liste.add(niveau);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}
