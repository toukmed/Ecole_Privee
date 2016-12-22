package ecole;

import exceptionClasses.InvalidInputExeption;

public class Administrateur extends Personne{
	private String cne;
	public Administrateur(String nom, String prenom, String addresse, String num, Compte compte,
			String photo,String cne) throws InvalidInputExeption {
		super(nom, prenom, addresse, num, compte, photo);
		this.cne = cne;
		// TODO Auto-generated constructor stub
	}

}
