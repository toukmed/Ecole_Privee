package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import ecole.Compte;
import ecole.Eleve;
import ecole.Personne;
import exceptionClasses.InvalidInputExeption;

import java.sql.PreparedStatement;

public class DaoCompte extends Dao implements Idao<Compte> {
	public Compte seConnecter(String matricule, String password){
			
			Compte resultat = null;
			String sql="select * from Comptes where matricule=? and password=?";
			if(connection != null){
			try {
				PreparedStatement pstm= connection.prepareStatement(sql);
				pstm.setString(1, matricule);
				pstm.setString(2, password);
				ResultSet rs= pstm.executeQuery();
				if(rs.next()) {
					resultat = new Compte(rs.getInt(1), rs.getString(2), rs.getString(3));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}	
			return resultat;
	}

	@Override
	public Compte find(int id) {
		Compte compte = null;
		ResultSet rs = null;
		Statement stmt;
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery("select * from comptes where id = " + id);
			if(rs.next())
				compte = new Compte(rs.getInt(1), rs.getString(2), rs.getString(3));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return compte;
	}

	@Override
	public void create(Compte T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Compte T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Compte T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	Personne getPersonne(Compte compte){
		String sql = "select * from personne where compte = " + compte.getIdCompte();
		ResultSet resultats = null;
		DaoCompte daoCompte = new DaoCompte();
		DaoTuteur managerTuteur = new DaoTuteur();
		DaoGroupe managerGroupe = new DaoGroupe();
		Eleve resultEleve = null;
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			if(resultats.next()){
				Eleve eleve;
				try {
					eleve = new Eleve(resultats.getString(2)
							, resultats.getString(3)
							, resultats.getString(5)
							,resultats.getString(6)
							,daoCompte.find(resultats.getInt(7)) 
							,resultats.getString(8)
							,managerGroupe.find(resultats.getInt(10))
							,managerTuteur.find(resultats.getInt(14))
					);
					eleve.setId(resultats.getInt(1));	
					resultEleve = eleve;
				} catch (InvalidInputExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultEleve;
	}
	
}
