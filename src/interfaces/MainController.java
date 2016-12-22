package interfaces;

import dao.DaoCompte;
import dao.DaoEleve;
import dao.DaoGroupe;
import dao.DaoNiveau;
import dao.DaoTuteur;

public class MainController {
	DaoEleve managerEleve = new DaoEleve();
	DaoGroupe managerGroupe = new DaoGroupe();
	DaoTuteur managerTuteur = new DaoTuteur();
	DaoCompte managerCompte = new DaoCompte();
	DaoNiveau managerNiveau = new DaoNiveau();
	
}
