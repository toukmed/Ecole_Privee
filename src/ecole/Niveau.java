package ecole;

import java.util.ArrayList;
import java.util.List;

public class Niveau {
 private String libelle;
 private int code;
 private List<Groupe> ListeGroupe =new ArrayList<Groupe>();
 private List<Semestre> listeSemestre = new ArrayList<Semestre>();
public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public Niveau(String libelle, int code) {
	super();
	this.libelle = libelle;
	this.code = code;
}
@Override
	public String toString() {
		// TODO Auto-generated method stub
		return libelle;
	}




}
