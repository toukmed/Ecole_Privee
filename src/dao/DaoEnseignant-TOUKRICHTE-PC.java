package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ecole.Eleve;
import ecole.Enseignant;
import exceptionClasses.InvalidInputExeption;

public class DaoEnseignant extends Dao implements Idao<Enseignant>{

	@Override
	public Enseignant find(int id) {
Enseignant ens = null;
	    DaoCompte  daoCompte = new DaoCompte();
		String sql = "select * from personne where  id = " + id;
		ResultSet resultats = null;
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			if(resultats.next()){
				try {
					Enseignant en =new Enseignant(resultats.getString(2)
							,resultats.getString(3)
							,resultats.getString(5)
							,resultats.getString(6)
							,daoCompte.find(resultats.getInt(7))
							,resultats.getString(8)
							,resultats.getString(14)
							//on va ajouter le cne f la bd
						);
					ens=en;
				} catch (InvalidInputExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

    
		}
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ens;



		}

	@Override
	public void create(Enseignant T) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Enseignant T) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Enseignant T) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
