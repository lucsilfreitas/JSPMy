package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.SingleConnection;

public class DaoLogin {
	
	private Connection connection;
	
	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws SQLException {		
	    String sql = "SELECT * FROM usuario WHERE login = '" + login + "' AND senha = '" + senha + "'";
	    try (PreparedStatement statement = connection.prepareStatement(sql);) {
	        try (ResultSet result = statement.executeQuery()) {
		    return result.next();
		}			
	    }			
	}
	
	
	
	

}
