package exceptionClasses;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ExceptionsBox extends JFrame {
	static public void showError(Exception e){
		showError(e,"Erreur !");
	}
	static public void showError(Exception e,String title){
		JOptionPane.showMessageDialog(null, e.toString(), title, JOptionPane.ERROR_MESSAGE);
	}

}
