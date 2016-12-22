package ecole;

import java.util.ArrayList;
import java.util.List;

import exceptionClasses.InvalidInputExeption;

public class Tuteur extends Personne {
    
	private String cne;
	private String profession;
	List<Eleve> ListeEleve = new ArrayList<Eleve>();
	
	public Tuteur(){
		
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub att chwiya oukii waa 3rfti 5dmi nti diri les chemps ouii oki 
		return getNom() + getPrenom() + " ( " + getCne() + " )";
	}
	
	public Tuteur( String nom, String prenom, String addresse, String num, Compte compte,
			String photo, String cne, String profession) throws InvalidInputExeption{
		super(nom, prenom, addresse, num, compte, photo);
		this.cne = cne;
		this.profession = profession;
		
		// TODO Auto-generated constructor stub
	}
	

	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public List<Eleve> getListeEleve() {
		return ListeEleve;
	}
	public void setListeEleve(List<Eleve> listeEleve) {
		ListeEleve = listeEleve;
	}
	
	

}
