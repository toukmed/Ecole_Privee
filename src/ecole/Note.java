package ecole;

public class Note {
	private int id ;
	private Eleve eleve;
	private Matiere matiere;
	private double note;
	
	
	public Note(Eleve eleve, Matiere matiere, double note) {
		super();
		this.eleve = eleve;
		this.matiere = matiere;
		this.note = note;
	}
	public Eleve getEleve() {
		return eleve;
	}
	public void setEleve(Eleve eleve) {
		this.eleve = eleve;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	
}
