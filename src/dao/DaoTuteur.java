package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ecole.Compte;
import ecole.Eleve;
import ecole.Groupe;
import ecole.Niveau;
import ecole.Tuteur;
import exceptionClasses.InvalidInputExeption;

public class DaoTuteur extends Dao implements Idao<Tuteur> {
	public void AjouterTuteur(Tuteur tuteur){
		
	}

	@Override
	public Tuteur find(int id) {
		String sql = "select * from personne where fonction = 'tuteur' and id = " + id;
		ResultSet resultats = null;
		DaoCompte daoCompte = new DaoCompte();
		Tuteur resultTuteur = null;
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			if(resultats.next()){
				try {
					resultTuteur = new Tuteur(resultats.getString(2)
							, resultats.getString(3)
							, resultats.getString(5)
							, resultats.getString(6)
							, daoCompte.find(resultats.getInt(7)) 
							, "seflk"
							, resultats.getString(4)
							, resultats.getString(13)
					);
					resultTuteur.setId(resultats.getInt(1));
				} catch (InvalidInputExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultTuteur;
	}

	@Override
	public void create(Tuteur tuteur) {
		Tuteur resultat = null;
		String sql = "insert into personne (nom,prenom,adresse,telephone,compte,photo,profession,cin,fonction) values (?,?,?,?,null,?,?,?,'tuteur')";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, tuteur.getNom());
			stmt.setString(2, tuteur.getPrenom());
			stmt.setString(3, tuteur.getAddresse());
			stmt.setString(4, tuteur.getNum());
			//stmt.setInt(6, eleve.getCompte().getIdCompte());
			stmt.setString(5, "");
			stmt.setString(6, tuteur.getProfession());
			stmt.setString(7, tuteur.getCne());
			stmt.execute();
			String req = "select max(id) from personne";
			Statement stm = connection.createStatement();
			ResultSet rs = stm.executeQuery(req);
			rs.next();
			int id = rs.getInt(1);
			tuteur.setId(id);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(Tuteur T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Tuteur T) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tuteur> findAll() {
		String sql = "select * from personne where fonction = 'tuteur'";
		ResultSet resultats = null;
		DaoCompte managerCompte = new DaoCompte();
		List<Tuteur> liste = new ArrayList<Tuteur>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				//Tuteur( String nom, String prenom, String addresse, String num, Compte compte,
//	String photo, String cne, String profession)
				Tuteur tuteur;
				try {
					tuteur = new Tuteur(resultats.getString(2),
							resultats.getString(3),
							resultats.getString(5),
							resultats.getString(6),
							managerCompte.find(resultats.getInt(7)),
							"",
							resultats.getString(4),
							resultats.getString(13)
							);
					liste.add(tuteur);
					tuteur.setId(resultats.getInt(1));
				} catch (InvalidInputExeption e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return liste;
	}

}
