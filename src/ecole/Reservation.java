package ecole;

import java.nio.channels.ClosedChannelException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation extends Thread{


	private int id_reservation;
	private Date dateDebut;
	private Date dateFin;
	private List<Local> listeLocaux = new ArrayList<Local>();
	private Client client;

	public Reservation() {
		SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
		try {
			dateFin = date.parse("2016-12-22 19:55:50");
			dateDebut = date.parse("2016-12-22 19:56:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}



	public int getId_reservation() {
		return id_reservation;
	}
	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public List<Local> getListeLocaux() {
		return listeLocaux;
	}
	public void setListeLocaux(List<Local> listeLocaux) {
		this.listeLocaux = listeLocaux;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public synchronized void run() {

		Local local;
		if(Local.isEtat() == false){

			local = new Local();
			local.setId_local(1);
			listeLocaux.add(local);
			local.setEtat(true);
			try {
				System.out.println(local.isEtat());
				Thread.sleep((dateFin.getTime()-dateDebut.getTime()));
				local.setEtat(false);
				System.out.println(local.isEtat());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else{
			System.out.println("Desolé salle deja reservée elle sera disponible a la date :"+dateFin);
		}
	}

}
