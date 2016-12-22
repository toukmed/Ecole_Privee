package interfaces;


import javafx.scene.control.Label;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.jfoenix.controls.JFXPasswordField;
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
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;

public class AjouterEleveFrameControler extends MainController implements Initializable{

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
    	Tuteur tuteur = null;
    	if(AjouterTuteurButton.isSelected()){
    		
	    	try {
				tuteur = new Tuteur(nomTuteur.getText(), prenomTuteur.getText(), adresseTuteur.getText(),telephoneTuteur.getText(),new Compte(2,"",""), "", cneTuteur.getText(), professionTuteur.getText());
				DaoTuteur daoTuteur = new DaoTuteur();
		    	daoTuteur.create(tuteur);
	    	} catch (InvalidInputExeption e) {
				// TODO Auto-generated catch block
				ExceptionsBox.showError(e);
			}
	    	
    	}else{
    		System.out.println("value combobox "+tuteurExistantC.getValue());
    		if(tuteurExistantC.getValue() != null){
    			tuteur = tuteurExistantC.getValue();
    			//System.out.println(tuteur);
    		}else{
    			Alert alert = new Alert(AlertType.WARNING, "Parametres de connection invalides !", ButtonType.CANCEL);
        		alert.showAndWait();
    		}
    		
    	}
    	
    	Eleve eleve;
		try {
			eleve = new Eleve( nomEleve.getText(), prenomEleve.getText(), adresseEleve.getText(), telephoneEleve.getText(),new Compte(2,"",""), "", groupeEleve.getValue(), tuteur);
			DaoEleve managerEleve = new DaoEleve();
	    	managerEleve.create(eleve);// hana bghit ntester wlit f error hhhhhhhhhhhOMG
	    	((Node)(event.getSource())).getScene().getWindow().hide();/// anwrik lghalat li kan 3ndi oki hizi ton telephone oOK
		} catch (InvalidInputExeption e) {
			// TODO Auto-generated catch block
			ExceptionsBox.showError(e);
		}
    	
    }
    
    @FXML
    void Annuler(ActionEvent event) {
    	((Node)(event.getSource())).getScene().getWindow().hide(); 
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		niveauEleve.setPromptText("Choisir un niveau");
		groupeEleve.setPromptText("Choisir un groupe");
		
		DaoNiveau managerNiveau = new DaoNiveau();
		List<Niveau> niveaux = managerNiveau.findAll();
		for(Niveau niveau : niveaux){
			niveauEleve.getItems().add(niveau);
		}
		
		List<Tuteur> tuteurs = managerTuteur.findAll();
		for(Tuteur tuteur : tuteurs){
			tuteurExistantC.getItems().add(tuteur);
		}
		
		AjouterTuteurButton.setSelected(true);
		
		
	}
   @FXML
    void selectNiveau(ActionEvent event) { 
	   groupeEleve.getItems().clear();// att ana j ayouki 7bas l vidéo bach n9dar nsma3 le mien
	   DaoGroupe managerGroupe = new DaoGroupe(); 
		List<Groupe> groupes = managerGroupe.findByNiveau(niveauEleve.getValue().getCode());
		for(Groupe groupe : groupes){
			groupeEleve.getItems().add(groupe);
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

}
