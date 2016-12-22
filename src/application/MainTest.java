package application;

import dao.DaoMatiere;
import dao.DaoModule;
import dao.DaoNiveau;
import dao.DaoSemestre;
import ecole.Matiere;
import ecole.Module;
import ecole.Niveau;
import ecole.Semestre;

public class MainTest {

	public static void main(String[] args) {

			Niveau niveau1 = new Niveau();
			niveau1.setLibelle("Niveau 1");

			DaoNiveau daoNiveau = new DaoNiveau();
			daoNiveau.create(niveau1);

			Semestre semestre1 = new  Semestre();
			semestre1.setLibelleSemestre("S1");
			semestre1.setNiveau(niveau1);

			DaoSemestre daoSemestre = new DaoSemestre();
			daoSemestre.create(semestre1);

			Module module1 = new Module();
			module1.setLibelleModule("Mathematiques");
			module1.setSemestre(semestre1);

			DaoModule daoModule = new DaoModule();
			daoModule.create(module1);

			Matiere matiere1 = new Matiere();
			matiere1.setLibelleMatiere("Math");
			matiere1.setCoefMatiere(3);
			matiere1.setModule(module1);

			DaoMatiere daoMatiere = new DaoMatiere();
			daoMatiere.create(matiere1);
		}

}
