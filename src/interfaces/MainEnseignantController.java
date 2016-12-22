package interfaces;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import ecole.Enseignant;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainEnseignantController {
	private Enseignant enseignant;
    @FXML
    private JFXButton onElevesClick;

    @FXML
    private JFXButton onCoursClick;

    @FXML
    private JFXButton onEmploiClick;

    @FXML
    private JFXButton onNoteClick;

    @FXML
    private JFXButton DeconnectButton;

    @FXML
    private JFXButton rechercheButton;

    @FXML
    private JFXTextField rechercheField;
    
    public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}
    @FXML
    void DeconnectButtonAction(ActionEvent event) {

    }

    @FXML
    void onCoursClickAction(ActionEvent event) {

    }

    @FXML
    void onElevesClickAction(ActionEvent event) {

    }

    @FXML
    void onEmploiClickAction(ActionEvent event) {

    }
    
    @FXML
    void onNoteClickAction(ActionEvent event) {
    	Stage stage = new Stage();
		FXMLLoader fxml = new FXMLLoader();
        Parent root = null;
        try {
			root = fxml.load(getClass().getResource("Notes.fxml").openStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
        stage.setScene(new Scene(root));
		stage.show();

    }

    @FXML
    void rechercheButtonAction(ActionEvent event) {

    }

    @FXML
    void rechercheFieldAction(ActionEvent event) {

    }

}
