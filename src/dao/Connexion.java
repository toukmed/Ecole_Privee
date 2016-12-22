package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

	public class Connexion {
		private static Connexion connexion=null;
		private Connection connection;
		
		
		private Connexion(){
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} 
			 String url="jdbc:mysql://localhost:3306/ecole"; 
				try {
				connection = DriverManager.getConnection(url, "root", "");
			} catch (SQLException e) {
				System.out.println("Imposible de se connecter au serveur !");
				Alert alert = new Alert(AlertType.WARNING, "Imposible de se connecter au serveur !", ButtonType.CANCEL);
        		alert.showAndWait();
        		
			}

		}
		
		public static Connexion getInstance(){
			if(connexion==null)
				connexion=new Connexion();
			return connexion;
		}
		public Connection getConnection(){
			return connection;
		}
	}

