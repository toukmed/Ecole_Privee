package ecole;

import java.util.ArrayList;
import java.util.List;



public class Groupe {
	private int code;
	private String libelle;
	private Niveau niv;
	private List<Eleve> listeEleves = new ArrayList<Eleve>();
	public Groupe(int code,String libelle,Niveau niveau) {
		this.niv = niveau;
		this.code = code;
		this.libelle = libelle;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return libelle;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public Niveau getNiv() {
		return niv;
	}
	public void setNiv(Niveau niv) {
		this.niv = niv;
	}



}
