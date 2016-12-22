package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ecole.Niveau;
import ecole.Semestre;

public class DaoSemestre extends Dao implements Idao<Semestre> {

	@Override
	public Semestre find(int id) {
		String sql = "select * from semestre where id = " + id;
		Semestre semestre =null;
		try {
			Statement stmt = connection.createStatement();
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return semestre;
	}

	@Override
	public void create(Semestre T) {
		String sql = "insert into semestre (id_niveau,libelle) values (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, T.getNiveau().getCode());
			stmt.setString(2, T.getLibelleSemestre());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Semestre T) {
		String sql = "delete from semestre where id = " + T.getId();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(Semestre T) {
		String sql = "update semestre set libelle = ?, id_niveau = ? where id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, T.getLibelleSemestre());
			stmt.setInt(2, T.getNiveau().getCode());
			stmt.setInt(3, T.getId());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Semestre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Semestre> findByNiveau(Niveau niveau){
		String sql = "select * from semestre where id_niveau = " + niveau.getCode();
		ResultSet resultats = null;
		List<Semestre> liste = new ArrayList<Semestre>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			DaoNiveau managerNiveau = new DaoNiveau();
			while(resultats.next()){
			Semestre semestre;
			semestre = new Semestre(managerNiveau.find(resultats.getInt(2)),resultats.getInt(1),resultats.getString(3));
			liste.add(semestre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}
