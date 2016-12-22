package ecole;

public class Evaluation {

	private double note;
	private Matiere matiere;
	private Enseignant enseignant;



	public Evaluation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Evaluation(double note, Matiere matiere, Enseignant enseignant) {
		super();
		this.note = note;
		this.matiere = matiere;
		this.enseignant = enseignant;
	}



	public double getNote() {
		return note;
	}
	public void setNote(double note) {
		this.note = note;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Enseignant getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}


}
