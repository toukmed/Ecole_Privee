package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import ecole.Inscription;
import ecole.Note;

public class DaoNote extends Dao implements Idao<Note> {

	@Override
	public Note find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(Note note) {
		String sql = "insert into notes (eleve,matiere,note) values (?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1,  note.getEleve().getId());
			stmt.setInt(2, note.getMatiere().getId_matiere());
			stmt.setDouble(3, note.getNote());
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Note T) {
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
	public void update(Note T) {

	}

	@Override
	public List<Note> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
