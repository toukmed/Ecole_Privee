package ecole;

import java.util.ArrayList;
import java.util.List;

public class Module {

	private int id_Module;
	private String libelleModule;
	private Semestre semestre;
	private List<Matiere> ListeMatiere =new ArrayList<Matiere>();



	public Module(String matriculeModule, String libelleModule, Semestre semestre, List<Matiere> listeMatiere) {
		super();
		this.id_Module = id_Module;
		this.libelleModule = libelleModule;
		this.semestre = semestre;
		ListeMatiere = listeMatiere;
	}
	public Module() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_Module() {
		return id_Module;
	}
	public void setId_Module(int id_Module) {
		this.id_Module = id_Module;
	}
	public String getLibelleModule() {
		return libelleModule;
	}
	public void setLibelleModule(String libelleModule) {
		this.libelleModule = libelleModule;
	}
	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	public List<Matiere> getListeMatiere() {
		return ListeMatiere;
	}
	public void setListeMatiere(List<Matiere> listeMatiere) {
		ListeMatiere = listeMatiere;
	}

}
