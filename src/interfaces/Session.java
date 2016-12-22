package interfaces;

import ecole.Compte;

public class Session {
	private Compte user;
	
	public void startSession(Compte compte){
		this.user = compte;
	}
	
	public Compte getSession(){
		return user;
	}
	
	public void destroySession(){
		this.user = null;
	}
	 public boolean isdefined(){
		 return !(user == null) ;
	 }
	
}
