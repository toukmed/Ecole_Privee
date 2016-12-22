package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ecole.Inscription;

public class DaoInscription extends Dao implements Idao<Inscription> {

	@Override
	public Inscription find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Inscription inscription) {
		String sql = "insert into inscriptions (annee,eleve,niveau) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, inscription.getAnnee());
			stmt.setInt(2, inscription.getEleve().getId());
			stmt.setInt(3, inscription.getNiveau().getCode());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Inscription T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Inscription T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Inscription> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
