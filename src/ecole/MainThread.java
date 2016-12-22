package ecole;

public class MainThread{

	public static void main(String[] args) {

		Reservation reservation1 = new Reservation();
		Reservation reservation2 = new Reservation();

		reservation1.start();
		reservation2.start();

	}

}
