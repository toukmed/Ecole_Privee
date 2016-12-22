package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import ecole.Compte;
import ecole.Eleve;
import ecole.Groupe;
import ecole.Inscription;
import ecole.Matiere;
import ecole.Niveau;
import ecole.Note;
import ecole.Personne;
import ecole.Tuteur;
import exceptionClasses.InvalidInputExeption;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class DaoEleve extends Dao implements Idao<Eleve> {

	@Override
	public Eleve find(int id) {
		String sql = "select * from personne where fonction = 'eleve' and id = " + id;
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
							,resultats.getString(3)
							,resultats.getString(5)
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
	
	public Eleve findLast() {
		String sql = "select max(id) from personne where fonction = 'eleve'";
		ResultSet resultats = null;
		Eleve res = null;
		Statement stmt;
		try {
			stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			if(resultats.next())
				res = this.find(resultats.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
	
	@Override
	public void create(Eleve eleve) {
		String sql = "insert into personne (matricule,nom,prenom,adresse,telephone,compte,photo,niveau,groupe,tuteur,fonction) values (?,?,?,?,?,?,?,?,?,?,'eleve')";
		DaoInscription managerInscription = new DaoInscription();
		DaoEleve managerEleve = new DaoEleve();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, eleve.getMatricule());
			stmt.setString(2, eleve.getNom());
			stmt.setString(3, eleve.getPrenom());
			stmt.setString(4, eleve.getAddresse());
			stmt.setString(5, eleve.getNum());
			stmt.setInt(6, eleve.getCompte().getIdCompte());
			stmt.setString(7, "");
			stmt.setInt(8, eleve.getGroupe().getNiv().getCode());
			stmt.setInt(9, eleve.getGroupe().getCode());
			stmt.setInt(10, eleve.getTuteur().getId());
			stmt.execute();
			Date date = new Date();
			String annee = "" + date.getYear() + "/" + date.getYear()+1;
			Inscription ins = new Inscription(annee, managerEleve.findLast(), eleve.getGroupe().getNiv());
			managerInscription.create(ins);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Eleve eleve) {
		String sql = "Delete from personne"
				+ " where id = ?";
		System.out.println(sql);
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, eleve.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void update(Eleve eleve) {
		String sql = "update personne set "
				+ " matricule = ?"
				+ " , nom = ?"
				+ " , prenom = ?"
				+ " , adresse = ?"
				+ " , telephone = ?"
				+ " , compte = ?"
				+ " , photo = ?"
				+ " , niveau = ?"
				+ " , groupe = ?"
				+ " , tuteur = ?"
				+ " where id = " + eleve.getId();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, eleve.getMatricule());
			stmt.setString(2, eleve.getNom());
			stmt.setString(3, eleve.getPrenom());
			stmt.setString(4, eleve.getAddresse());
			stmt.setString(5, eleve.getNum());
			if(eleve.getCompte() != null)
				stmt.setInt(6, eleve.getCompte().getIdCompte());
			else
				stmt.setObject(6, null);
				
			stmt.setString(7, "");
			stmt.setInt(8, eleve.getGroupe().getNiv().getCode());
			stmt.setInt(9, eleve.getGroupe().getCode());
			stmt.setInt(10, eleve.getTuteur().getId());
			stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public List<Eleve> findAll() {
		String sql = "select * from personne where fonction = 'eleve'";
		ResultSet resultats = null;
		DaoCompte daoCompte = new DaoCompte();
		DaoGroupe managerGroupe = new DaoGroupe();
		DaoTuteur managerTuteur = new DaoTuteur();
		List<Eleve> liste = new ArrayList<Eleve>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				Eleve eleve;
				try {
					eleve = new Eleve(resultats.getString(2), resultats.getString(3), resultats.getString(5)
							,resultats.getString(6)
							,daoCompte.find(resultats.getInt(7)) 
							,resultats.getString(8)
							,managerGroupe.find(resultats.getInt(10))
							,managerTuteur.find(resultats.getInt(14))
					);
					eleve.setId(resultats.getInt(1));
					liste.add(eleve);
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
	public List<Eleve> findByGroupe(int groupe){
		String sql = "select * from personne where fonction = 'eleve' and groupe = " + groupe;
		ResultSet resultats = null;
		DaoCompte daoCompte = new DaoCompte();
		DaoGroupe managerGroupe = new DaoGroupe();
		DaoTuteur managerTuteur = new DaoTuteur();
		List<Eleve> liste = new ArrayList<Eleve>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				Eleve eleve;
				try {
					eleve = new Eleve(resultats.getString(2), resultats.getString(3), resultats.getString(5)
							,resultats.getString(6)
							,daoCompte.find(resultats.getInt(7)) 
							,resultats.getString(8)
							,managerGroupe.find(resultats.getInt(10))
							,managerTuteur.find(resultats.getInt(14))
					);
					eleve.setId(resultats.getInt(1));
				    liste.add(eleve);
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
	public List<Eleve> findByNom(String nom){
		String sql = "select * from personne where fonction = 'eleve' and (nom like'%" + nom + "%' or prenom like'%" + nom + "%')";
		ResultSet resultats = null;
		DaoCompte daoCompte = new DaoCompte();
		DaoGroupe managerGroupe = new DaoGroupe();
		DaoTuteur managerTuteur = new DaoTuteur();
		List<Eleve> liste = new ArrayList<Eleve>();
		try {
			Statement stmt = connection.createStatement();
			resultats = stmt.executeQuery(sql);
			while(resultats.next()){
				Eleve eleve;
				try {
					eleve = new Eleve(resultats.getString(2), resultats.getString(3), resultats.getString(5)
							,resultats.getString(6)
							,daoCompte.find(resultats.getInt(7)) 
							,resultats.getString(8)
							,managerGroupe.find(resultats.getInt(10))
							,managerTuteur.find(resultats.getInt(14))
					);
					eleve.setId(resultats.getInt(1));
					liste.add(eleve);
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
	
	
	public void ajouterNote(Eleve eleve, Matiere matiere, double n){
		Note note = new Note(eleve, matiere, n);
		DaoNote managerNote = new DaoNote();
		managerNote.create(note);
	}
}
