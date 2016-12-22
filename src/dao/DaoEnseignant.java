package dao;

import java.util.List;

import ecole.Compte;
import ecole.Enseignant;

public class DaoEnseignant extends Dao implements Idao<Enseignant>{


	public Enseignant findByCompte(Compte compte){
		String sql = "select * from personne where compte = " + compte.getIdCompte();


		return null;
	}
	public Compte getCompte(Enseignant enseignant){
		DaoCompte managerCompte = new DaoCompte();
		Compte compte = managerCompte.find(enseignant.getCompte().getIdCompte());
		return compte;
	}

	@Override
	public Enseignant find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void create(Enseignant T) {
		// TODO Auto-generated method stub

	}
	@Override
	public void delete(Enseignant T) {
		// TODO Auto-generated method stub

	}
	@Override
	public void update(Enseignant T) {
		// TODO Auto-generated method stub

	}
	@Override
	public List<Enseignant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
