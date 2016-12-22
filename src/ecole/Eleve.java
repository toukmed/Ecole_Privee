package ecole;

import java.util.Date;

import exceptionClasses.InvalidInputExeption;

public class Eleve extends Personne{
    private Groupe groupe;
    private Tuteur tuteur;


	public Eleve(String nom, String prenom, String addresse, String num, Compte compte,
			String photo, Groupe groupe, Tuteur tuteur) throws InvalidInputExeption {
		super(nom, prenom, addresse, num, compte, photo);
		this.groupe = groupe;
		this.tuteur = tuteur;
		// TODO Auto-generated constructor stub
	}
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	public Tuteur getTuteur() {
		return tuteur;
	}
	public void setTuteur(Tuteur tuteur) {
		this.tuteur = tuteur;
	}
    public void DemanderFichier(/*parametres*/){

    }



}
