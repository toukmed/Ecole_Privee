package ecole;

import java.util.ArrayList;
import java.util.List;

public class Semestre {

	private Niveau niveau;
	private int id;
	private String libelleSemestre;
	private List<Module> ListeModule =new ArrayList<Module>();

	public Semestre() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Semestre(Niveau niveau, int matriculeSemestre, String libelleSemestre) {
		super();
		this.niveau = niveau;
		this.id = matriculeSemestre;
		this.libelleSemestre = libelleSemestre;
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
	public void setId(int matricule) {
		this.id = matricule;
	}
	public String getLibelleSemestre() {
		return libelleSemestre;
	}
	public void setLibelleSemestre(String libelleSemestre) {
		this.libelleSemestre = libelleSemestre;
	}
	public List<Module> getListeModule() {
		return ListeModule;
	}
	public void setListeModule(List<Module> listeModule) {
		ListeModule = listeModule;
	}

}
