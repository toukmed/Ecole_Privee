package exceptionClasses;

public class InvalidInputExeption extends Exception {
	String string;
	
	public InvalidInputExeption(String string) {
		this.string = string;
	}
	
	public String getString() {
		return string;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Invalid Input Exception in : " + string;
	}

}
