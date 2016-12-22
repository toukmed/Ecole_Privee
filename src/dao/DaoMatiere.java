package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ecole.Matiere;
import ecole.Module;
import ecole.Niveau;
import ecole.Semestre;

public class DaoMatiere extends Dao implements Idao<Matiere> {

	PreparedStatement pstm = null;
	ResultSet rs = null;
	String sql = null;

	@Override
	public Matiere find(int id) {
		Matiere matiere = new Matiere();
		DaoModule module = new DaoModule();
		sql = "SELECT * FROM matiere WHERE id_matiere = "+id;
		try {
			pstm = connection.prepareStatement(sql);
			rs = pstm.executeQuery();
			if(rs.next()){
				matiere.setId_matiere(rs.getInt(1));
				matiere.setLibelleMatiere(rs.getString(2));
				matiere.setCoef_matiere(rs.getInt(3));
				matiere.setModule(module.find(rs.getInt(4)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return matiere;
	}

	@Override
	public void create(Matiere T) {
		sql = "INSERT INTO matiere(libelle, coeficient, module) VALUES(?, ?, ?)";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, T.getLibelleMatiere());
			pstm.setInt(2, T.getCoef_matiere());
			pstm.setInt(3, T.getModule().getId_Module());
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Matiere T) {
		sql = "DELETE FROM matiere where id = ?";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setInt(1, T.getId_matiere());
			pstm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(Matiere T) {
		sql = "UPDATE matiere set "+"libelle = ?"+"coeficient = ?"+"module = ?";
		try {
			pstm = connection.prepareStatement(sql);
			pstm.setString(1, T.getLibelleMatiere());
			pstm.setInt(2, T.getCoef_matiere());
			pstm.setInt(3, T.getModule().getId_Module());
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Matiere> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
