package ecole;

public class Matiere {

	private int id_matiere;
	private int coef_matiere;
	private String libelleMatiere;
	private Module module;
	private Evaluation evaluation;

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Matiere(int id_matiere, int coef_matiere, String libelleMatiere, Module module, Evaluation evaluation) {
		super();
		this.id_matiere = id_matiere;
		this.coef_matiere = coef_matiere;
		this.libelleMatiere = libelleMatiere;
		this.module = module;
		this.evaluation = evaluation;
	}



	public int getId_matiere() {
		return id_matiere;
	}

	public void setId_matiere(int id_matiere) {
		this.id_matiere = id_matiere;
	}
	public String getLibelleMatiere() {
		return libelleMatiere;
	}
	public void setLibelleMatiere(String libelleMatiere) {
		this.libelleMatiere = libelleMatiere;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}

	public Evaluation getEvaluation() {
		return evaluation;
	}
	public void setEvaluation(Evaluation evaluation) {
		this.evaluation = evaluation;
	}
	public int getCoef_matiere() {
		return coef_matiere;
	}
	public void setCoef_matiere(int coef_matiere) {
		this.coef_matiere = coef_matiere;
	}

}
