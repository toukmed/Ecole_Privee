package ecole;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import exceptionClasses.InvalidInputExeption;

public class Reservation extends Thread{

	private int id_reservation;
	private Date dateDebut = new Date();
	private Date dateFin = new Date();
	private long duree;
	private List<Local> listeLocaux = new ArrayList<Local>();
	private Client client;

//	public Reservation() {
//		SimpleDateFormat date = new SimpleDateFormat("YYYY-MM-
	//DD hh:mm:ss");
//		try {
//			dateFin = date.parse("2016-12-22 20:23:10");
//			dateDebut = date.parse("2016-12-22 20:23:00");
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}



	public long getDuree() {
		return duree;
	}
	public void setDuree(long duree) {
		duree = dateFin.getTime()-dateDebut.getTime();
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
	public void run() {

		Local local;
		if(Local.isEtat() == false){

			System.out.println(Local.isEtat());
			local = new Local();
			local.setId_local(1);
			listeLocaux.add(local);
			local.setEtat(true);
			client = new Client();

			try {
				client.setNom("toto");
				System.out.println("etat : "+local.isEtat()+", "
						+ "duration :"+getDuree());
				Thread.sleep((dateFin.getTime()-dateDebut.
						getTime()));
				local.setEtat(false);

				System.out.println(local.isEtat());
			} catch (InterruptedException | InvalidInputExeption e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else{
			System.out.println("Desolé salle deja reservée "
					+ "elle sera disponible a la date :"+dateFin);
		}
	}

	public boolean reserverLocal(){
		while(true){
			SimpleDateFormat date = new SimpleDateFormat("YYYY-"
					+ "MM-DD hh:mm:ss");
			Scanner scanner = new Scanner(System.in);
			System.out.print("entrez la date debut : ");
			try {
				dateDebut = date.parse(scanner.nextLine());
				System.out.println("tapez la date fin : ");
				dateFin = date.parse(scanner.nextLine());
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Reservation reservation1 = new Reservation();

			reservation1.start();
			try {
				reservation1.join(reservation1.getDuree());
				if(Thread.currentThread().isAlive()) Thread.
				currentThread().interrupt();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}



}
