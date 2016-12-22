package ecole;


public class Compte {
	private int idCompte;
	private String matricule;
	private String password;

	public Compte(int idCompte, String matricule, String password) {
		this.idCompte = idCompte;
		this.matricule = matricule;
		this.password = password;
	}
	public int getIdCompte() {
		return idCompte;

	}
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
