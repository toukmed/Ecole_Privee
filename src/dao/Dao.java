package dao;

import java.sql.Connection;

public abstract class Dao {
	protected Connection connection = Connexion.getInstance().getConnection();
	
}
