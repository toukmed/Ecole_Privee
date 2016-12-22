package interfaces;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DaoCompte;
import dao.DaoEnseignant;
import ecole.Compte;
import ecole.Enseignant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class LoginControler implements Initializable{

	@FXML
	private AnchorPane frame;
    @FXML
    private TextField matricule;
    
    @FXML
    private Button login;

    @FXML
    private Button annuler;

    @FXML
    private PasswordField password;

    @FXML
    void annuler(ActionEvent event) {
    	System.exit(0);
    }
    
    @FXML
    void login(ActionEvent event) throws IOException {
    	DaoCompte user = new DaoCompte();
    	Compte compte = user.seConnecter(matricule.getText(), password.getText());
    	if(compte == null){
    		Alert alert = new Alert(AlertType.WARNING, "Parametres de connection invalides !", ButtonType.CANCEL);
    		alert.showAndWait();
    	}else{
    		//
    		((Node)(event.getSource())).getScene().getWindow().hide(); 
    		String role = matricule.getText().substring(0, 2);
    		if(role.equals("AS")){
    			Stage stage = new Stage();
    			FXMLLoader fxml = new FXMLLoader();
    	        Parent root = null;
    	        root = fxml.load(getClass().getResource("Scolarite.fxml").openStream());// belati 
    	        ScolariteFrameControler HomeController = (ScolariteFrameControler) fxml.getController();// wakha db dak session fen rat7tao fe fe dak HomeController ? 
    	        Session session = new Session();
    	        session.startSession(compte); // hada fen huwa compte m instansé ?
    	        HomeController.setSession(session);// ok att n9ra l code ok ok // 3ad jiti lhna o 3ayti ala l fonction li inisialisat session 
    			stage.setScene(new Scene(root));
    			stage.show();
    			//activi l mique ndwiw katm3 dab a?
    		}else{
    			if(role.equals("EN")){
    				DaoEnseignant managerEneignant = new DaoEnseignant();
    				//Enseignant enseignant = managerEneignant.findByCompte(compte);
    				Stage stage = new Stage();
        			FXMLLoader fxml = new FXMLLoader();
        	        Parent root = null;
        	        root = fxml.load(getClass().getResource("Enseignant.fxml").openStream());
        	        //MainEnseignantController enseignantController = (MainEnseignantController)fxml.getController();
        	        //enseignantController.setEnseignant(enseignant);
        	        stage.setScene(new Scene(root));
        			stage.show();
    			}
    		}
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
