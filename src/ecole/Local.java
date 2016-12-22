package ecole;

import java.util.List;

public class Local {

	private int id_local;
	private static boolean etat = false;
	private List<Reservation> listeReservations;
	public int getId_local() {
		return id_local;
	}
	public void setId_local(int id_local) {
		this.id_local = id_local;
	}
	public static boolean isEtat() {
		return etat;
	}
	public void setEtat(boolean etat) {
		this.etat = etat;
	}
	public List<Reservation> getListeReservations() {
		return listeReservations;
	}
	public void setListeReservations(List<Reservation> listeReservations) {
		Reservation reservation = new Reservation();
		listeReservations.add(reservation);
	}


}
