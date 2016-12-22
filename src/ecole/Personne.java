package ecole;

import java.util.regex.Pattern;

import javax.activity.InvalidActivityException;

import exceptionClasses.InvalidInputExeption;

public abstract class Personne {
	private int id;
	private String matricule;
    private String nom;
    private String prenom;
    private String addresse;
    private String num;
    private Compte compte;
    private String photo;
    
    public Personne() {
		// TODO Auto-generated constructor stub
	}
	public Personne( String nom, String prenom, String addresse, String num, Compte compte,
			String photo) throws InvalidInputExeption {
		super();
		
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAddresse(addresse);
		this.setNum(num);
		this.compte = compte;
		this.photo = photo;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
    
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) throws InvalidInputExeption {
		if(Pattern.matches("[a-zA-Z]{3,}", nom))
			this.nom = nom;
		else throw new InvalidInputExeption(nom);
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) throws InvalidInputExeption{
		if(Pattern.matches("[a-zA-Z]{3,}", prenom))
			this.prenom = prenom;
		else throw new InvalidInputExeption(prenom);
	}
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) throws InvalidInputExeption{
		if(Pattern.matches("[a-zA-Z]{3,}[',''.']*[a-zA-Z'.'',']*", addresse))
			this.addresse = addresse;
		else throw new InvalidInputExeption(addresse);
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) throws InvalidInputExeption{
		if(Pattern.matches("[0-9]{10,}", num))
			this.num = num;
		else throw new InvalidInputExeption(num);
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
    
	public void ConsulterFichier(){
		
	}

}
