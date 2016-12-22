package ecole;

import java.util.ArrayList;
import java.util.List;

import exceptionClasses.InvalidInputExeption;


public class Enseignant extends Personne{
    private String cne;
    List<Evaluation> ListeEvaluation =new ArrayList<Evaluation>();


    public Enseignant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Enseignant(String nom, String prenom, String addresse, String num, Compte compte, String photo, String cne )
			throws InvalidInputExeption {
		super(nom, prenom, addresse, num, compte, photo);
		this.cne=cne;
		// TODO Auto-generated constructor stub
	}
	public String getCne() {
		return cne;
	}
	public void setCne(String cne) {
		this.cne = cne;
	}
	public List<Evaluation> getListeEvaluation() {
		return ListeEvaluation;
	}
	public void setListeEvaluation(List<Evaluation> listeEvaluation) {
		ListeEvaluation = listeEvaluation;
	}






}
