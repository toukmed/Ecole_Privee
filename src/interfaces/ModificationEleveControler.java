package interfaces;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import dao.DaoEleve;
import dao.DaoGroupe;
import dao.DaoNiveau;
import dao.DaoTuteur;
import ecole.Compte;
import ecole.Eleve;
import ecole.Groupe;
import ecole.Niveau;
import ecole.Tuteur;
import exceptionClasses.ExceptionsBox;
import exceptionClasses.InvalidInputExeption;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class ModificationEleveControler implements Initializable {

	private Eleve eleve;
	private Tuteur tuteur;
	private DaoEleve managerEleve = new DaoEleve();
	@FXML
    private Label nomTuteurL;

    @FXML
    private Label prenomTuteurL;

    @FXML
    private Label telephoneTuteurL;
    
    @FXML
    private Label cneTuteurL;

    @FXML
    private Label prefessionTuteurL;
    
    @FXML
    private Label addresseTuteurL;

    @FXML
    private JFXTextField nomEleve;

    @FXML
    private JFXTextField prenomEleve;

    @FXML
    private JFXTextField telephoneEleve;

    @FXML
    private JFXTextField nomTuteur;

    @FXML
    private JFXTextField prenomTuteur;

    @FXML
    private JFXTextField telephoneTuteur;

    @FXML
    private JFXTextArea adresseEleve;

    @FXML
    private ComboBox<Niveau> niveauEleve;

    @FXML
    private ComboBox<Groupe> groupeEleve = new ComboBox<>();
    
    @FXML
    private ComboBox<Tuteur> tuteurExistantC;

    @FXML
    private JFXTextArea adresseTuteur;

    @FXML
    private JFXTextField cneTuteur;

    @FXML
    private JFXTextField professionTuteur;
    
    @FXML
    private RadioButton AjouterTuteurButton;

    @FXML
    private RadioButton TuteurExistantButton;
    @FXML
    void AjouterEleveAction(ActionEvent event) {

    }

    @FXML
    void Annuler(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide(); 
    }

    @FXML
    void selectNiveau(ActionEvent event) {
    	 groupeEleve.getItems().clear();
  	   DaoGroupe managerGroupe = new DaoGroupe(); 
  		List<Groupe> groupes = managerGroupe.findByNiveau(niveauEleve.getValue().getCode());
  		for(Groupe groupe : groupes){
  			groupeEleve.getItems().add(groupe);
  		}
    }
    @FXML
    void modifierEleveAction(ActionEvent event) {
    	try {
    		
    		eleve.setAddresse(adresseEleve.getText());
			eleve.setNom(nomEleve.getText());
			eleve.setNum(telephoneEleve.getText());
	    	eleve.setPrenom(prenomEleve.getText());
	    	if((groupeEleve.getValue() != null) && (niveauEleve.getValue() != null))
	    		eleve.setGroupe(groupeEleve.getValue());
	    	if(tuteurExistantC.getValue() != null){
	    		eleve.setTuteur(tuteurExistantC.getValue());
	    	}else{
	    		try {
    				tuteur = new Tuteur(nomTuteur.getText(), prenomTuteur.getText(), adresseTuteur.getText(),telephoneTuteur.getText(),new Compte(2,"",""), "", cneTuteur.getText(), professionTuteur.getText());
    				DaoTuteur daoTuteur = new DaoTuteur();
    		    	daoTuteur.create(tuteur);
	    	    	
				} catch (InvalidInputExeption e) {
					// TODO: handle exception
					ExceptionsBox.showError(e);
				}
	    	}
	    		
	    	managerEleve.update(eleve);
	    	
		} catch (InvalidInputExeption e) {
			// TODO Auto-generated catch block
			ExceptionsBox.showError(e);
		}
    	
    	
    	
    	
    }
    @FXML
    void ActionAjouterTuteur(ActionEvent event) {
 	   if(AjouterTuteurButton.isSelected()){
 		   TuteurExistantButton.setSelected(false);
 		   afficherFormulaireTuteur(true);
 		   
 	   }else {
 		   TuteurExistantButton.setSelected(true);
 		  afficherFormulaireTuteur(false);
 		   
 	   }
    }

    @FXML
    void ActionTuteurExistant(ActionEvent event) {
 	   if(TuteurExistantButton.isSelected()){
 		   AjouterTuteurButton.setSelected(false);
 		   
 		   afficherFormulaireTuteur(false);
 	   }else {
 		   AjouterTuteurButton.setSelected(true);
 		  afficherFormulaireTuteur(true);
 	   }
    }
    public void afficherFormulaireTuteur(boolean b){
 	   nomTuteur.setVisible(b);
 	   prenomTuteur.setVisible(b);
 	   adresseTuteur.setVisible(b);
 	   telephoneTuteur.setVisible(b);
        cneTuteur.setVisible(b);
        professionTuteur.setVisible(b);
        nomTuteurL.setVisible(b);
        prenomTuteurL.setVisible(b);
        telephoneTuteurL.setVisible(b);
        cneTuteurL.setVisible(b);
        prefessionTuteurL.setVisible(b);
        addresseTuteurL.setVisible(b);
 	   tuteurExistantC.setVisible(!b);
    }
    @FXML
    public void tuteurExistantCAction(ActionEvent event){
 	   
    }

    void setEleve(Eleve eleve){
    	this.eleve = eleve;
    	setInfoEleve(eleve);
    }
    void setInfoEleve(Eleve eleve){
    	this.nomEleve.setText(eleve.getNom()); 
    	this.prenomEleve.setText(eleve.getPrenom());
    	this.adresseEleve.setText(eleve.getAddresse());
    	this.telephoneEleve.setText(eleve.getNum());
    	this.niveauEleve.setPromptText(eleve.getGroupe().getNiv().getLibelle());
    	DaoNiveau managerNiveau = new DaoNiveau();
		List<Niveau> niveaux = managerNiveau.findAll();
		for(Niveau niveau : niveaux){
			 niveauEleve.getItems().add(niveau);
		}
		this.groupeEleve.setPromptText(eleve.getGroupe().getLibelle());
    }
    
    void setTuteur(Tuteur tuteur){
    	this.tuteur = tuteur;
    	tuteurExistantC.setPromptText(tuteur.getNom() + tuteur.getPrenom());
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		afficherFormulaireTuteur(false);
		TuteurExistantButton.setSelected(true);
		DaoTuteur managerTuteur = new DaoTuteur();
		List<Tuteur> tuteurs = managerTuteur.findAll();
		for(Tuteur tuteur : tuteurs){
			tuteurExistantC.getItems().add(tuteur);
		}
		
	}
}
