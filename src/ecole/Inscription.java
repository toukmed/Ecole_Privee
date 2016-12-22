package ecole;

public class Inscription {
	private int id;
	private String annee;
	private Eleve eleve;
	private Niveau niveau;

	public Inscription(String annee, Eleve eleve, Niveau niveau) {
		super();
		this.annee = annee;
		this.eleve = eleve;
		this.niveau = niveau;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Niveau getNiveau() {
		return niveau;
	}
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}
	public int getId() {
		return id;
	}
	
}
