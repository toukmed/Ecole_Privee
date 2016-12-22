package interfaces;

import java.awt.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import dao.DaoEleve;
import dao.DaoGroupe;
import dao.DaoNiveau;
import ecole.Personne;
import ecole.Compte;
import ecole.Eleve;
import ecole.Groupe;
import ecole.Niveau;
import interfaces.ScolariteFrameControler.EleveTable;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ScolariteFrameControler extends MainController implements Initializable{

	private Session session; //hna wé fen ratkhedm beh 
	@FXML
	private Label nomUser;// ghana5d mno le nom on7to fhad label ok wa fe dik setSession dir lblan li updati label :D
	
	@FXML
    private JFXTreeTableView<EleveTable> table;
	
	@FXML
    private ComboBox<Niveau> FilterByNiveau;

    @FXML
    private ComboBox<Groupe> FilterByGroupe;

    @FXML
    private JFXTextField findByNom;

    @FXML
    private JFXButton validerRecherche;

	@FXML
    private Label nomLable;

    @FXML
    private Label prenomLabel;

    @FXML
    private Label matriculeField;

    @FXML
    private Label addresseField;

    @FXML
    private Label emailField;

    @FXML
    private Label telephoneField;

    @FXML
    private Label niveauField;

    @FXML
    private Label groupeField;

    @FXML
    private Label tuteurField;


    @FXML
    private JFXButton modifierEleveButton;

    @FXML
    private JFXButton supprimerEleveButton;

    @FXML
    private JFXButton tuteurInfoButton;

    @FXML
    private JFXButton gestion_absence_button;

    @FXML
    private JFXButton Consulter_notes_button;

    @FXML
    private JFXButton suivre_evolutivite_button;
    

    
    @FXML
    void Consulter_notes_action(ActionEvent event) {

    }
    public void setSession(Session session) {
		this.session = session;
		nomUser.setText(this.session.getSession().getMatricule());

	}

    @FXML
    void ajouterEleve(ActionEvent event) {
    	Parent root;
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AjouterEleve.fxml"));     
			root = (Parent)fxmlLoader.load();          
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }

    @FXML
    void gestion_absance_action(ActionEvent event) {

    }

    @FXML
    void getInfoTuteur(ActionEvent event) {

    }

    @FXML
    void modifierEleve(ActionEvent event) throws IOException {
    	Stage stage = new Stage();
		FXMLLoader fxml = new FXMLLoader();
        Parent root = null;
        root = fxml.load(getClass().getResource("ModificationEleve.fxml").openStream());
        ModificationEleveControler HomeController = (ModificationEleveControler) fxml.getController();
        EleveTable eleve = table.getSelectionModel().getSelectedItem().getValue();
        DaoEleve managerEleve = new DaoEleve();
        HomeController.setEleve(managerEleve.find(eleve.id));
        HomeController.setTuteur(managerEleve.find(eleve.id).getTuteur());
		stage.setScene(new Scene(root));
		stage.show();
    }

    @FXML
    void suivre_evolutivite_action(ActionEvent event) {

    }

    @FXML
    void supprimerEleve(ActionEvent event) {
    	Alert alert = new Alert(
    			AlertType.CONFIRMATION,
    			"Delete " + table.getSelectionModel().getSelectedItem().getValue().nom.getValue() + " " + table.getSelectionModel().getSelectedItem().getValue().prenom.getValue() +  " ?",
    			ButtonType.YES,
    			ButtonType.NO
    	);
    	alert.showAndWait();

    	if (alert.getResult() == ButtonType.YES) {
    		managerEleve.delete(managerEleve.find(table.getSelectionModel().getSelectedItem().getValue().id));
    	}
    	
    }


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FilterByNiveau.setPromptText("Choisir le niveau");
		FilterByGroupe.setPromptText("Choisir le groupe");
		FilterByNiveau.getItems().add(new Niveau("Tout les niveaux", -1));
        DaoNiveau managerNiveau = new DaoNiveau();
		List<Niveau> niveaux = managerNiveau.findAll();
		for(Niveau niveau : niveaux){
			FilterByNiveau.getItems().add(niveau);
		}
	
	}
    
	class EleveTable extends RecursiveTreeObject<EleveTable> {
		
		int id;
        StringProperty nom;
        StringProperty prenom;
        StringProperty niveau;
        StringProperty groupe;

        public EleveTable(int id,String nom, String prenom, String niveau, String groupe) {
        	this.id = id;
            this.nom = new SimpleStringProperty(nom);
            this.prenom = new SimpleStringProperty(prenom);
            this.niveau = new SimpleStringProperty(niveau);
            this.groupe = new SimpleStringProperty(groupe);
        }

    }
	
	void selectionRowLisnner(){
		table.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				if(table.getSelectionModel().getSelectedItem() != null) 
		        {  
					EleveTable selectedEleve = table.getSelectionModel().getSelectedItem().getValue();
					showInfoEleveLisnner(selectedEleve.id);
		        }
			}
        });
	}
	
	void showInfoEleveLisnner(int id){
		DaoEleve managerEleve = new DaoEleve();
		Eleve eleve = managerEleve.find(id);
		nomLable.setText(eleve.getNom());
		prenomLabel.setText(eleve.getPrenom());
		matriculeField.setText(eleve.getMatricule());
		addresseField.setText(eleve.getAddresse());
		telephoneField.setText(eleve.getNum());
		niveauField.setText(eleve.getGroupe().getNiv().getLibelle());
		groupeField.setText(eleve.getGroupe().getLibelle());
		tuteurField.setText(eleve.getTuteur().getNom());
		tuteurInfoButton.setDisable(false);
		modifierEleveButton.setDisable(false);
		supprimerEleveButton.setDisable(false);
		
		
	}
	
	@FXML
    void FilterByGroupeAction(ActionEvent event) {
		DaoEleve managerEleve = new DaoEleve();
		if(FilterByGroupe.getValue() != null){
		List<Eleve> listeEleves = managerEleve.findByGroupe(FilterByGroupe.getValue().getCode());
		refreshTable(listeEleves);
		}
    }

    @FXML
    void FilterByNiveauAction(ActionEvent event) {
    	FilterByGroupe.getItems().clear();
    	FilterByGroupe.setDisable(false);
    	if(FilterByNiveau.getValue().getCode() == -1){
    		DaoEleve managerEleve = new DaoEleve();
    		refreshTable(managerEleve.findAll());
    		FilterByGroupe.setDisable(true);
    	}
    	else{
		   DaoGroupe managerGroupe = new DaoGroupe(); 
			List<Groupe> groupes = managerGroupe.findByNiveau(FilterByNiveau.getValue().getCode());
			for(Groupe groupe : groupes){
				FilterByGroupe.getItems().add(groupe);
			}
    	}
    }
    @FXML
    void validerRechercheAction(ActionEvent event) {
    	DaoEleve managerEleve = new DaoEleve();
    	List<Eleve> listeEleves = managerEleve.findByNom(findByNom.getText());
		refreshTable(listeEleves);
    }
    void refreshTable(List<ecole.Eleve> listEleves){
    	JFXTreeTableColumn<EleveTable, String> nomCol = new JFXTreeTableColumn<>("Nom");
		nomCol.setPrefWidth(100);
		nomCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EleveTable, String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EleveTable, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().nom;
			}
		});
		JFXTreeTableColumn<EleveTable, String> prenomCol = new JFXTreeTableColumn<>("Prenom");
		prenomCol.setPrefWidth(100);
		prenomCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EleveTable, String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EleveTable, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().prenom;
			}
		});
		JFXTreeTableColumn<EleveTable, String> niveauCol = new JFXTreeTableColumn<>("Niveau");
		niveauCol.setPrefWidth(100);
		niveauCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EleveTable, String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EleveTable, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().niveau;
			}
		});
		JFXTreeTableColumn<EleveTable, String> groupeCol = new JFXTreeTableColumn<>("Groupe");
		groupeCol.setPrefWidth(100);
		groupeCol.setCellValueFactory(new Callback<TreeTableColumn.CellDataFeatures<EleveTable, String>, ObservableValue<String>>() {
			
			@Override
			public ObservableValue<String> call(CellDataFeatures<EleveTable, String> param) {
				// TODO Auto-generated method stub
				return param.getValue().getValue().groupe;
			}
		});
		
    	ObservableList<EleveTable> eleves = FXCollections.observableArrayList();
		for (ecole.Eleve eleve : listEleves){
			EleveTable e = new EleveTable(eleve.getId(),eleve.getNom(), eleve.getPrenom(), eleve.getGroupe().getNiv().getLibelle(), eleve.getGroupe().getLibelle());
			eleves.add(e);
		}
		final TreeItem<EleveTable> root = new RecursiveTreeItem<EleveTable>(eleves, RecursiveTreeObject::getChildren);
        table.getColumns().setAll(nomCol, prenomCol, niveauCol,groupeCol);
        table.setRoot(root);
        table.setShowRoot(false);
        selectionRowLisnner();
    }
	
	
	
	

}
