package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.BeansCursoJSP;
import connection.SingleConnection;

public class DaoUsuario {
	
	private Connection connection;
	
	public DaoUsuario () {
		
		connection = SingleConnection.getConnection();
	}

	public void salvar(BeansCursoJSP usuario){
		
		try {
			
			String sql = "insert into usuario (login, senha) values (?, ?)"; 
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, usuario.getLogin());
			insert.setString(2, usuario.getSenha());
			insert.execute();
			connection.commit();
			}catch(Exception e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
	
					e1.printStackTrace();
				}
			}
		}
	
	public List<BeansCursoJSP> listar() throws Exception {
		
		List<BeansCursoJSP> listar = new ArrayList<BeansCursoJSP>();
		
		String sql = "select * from usuario";
		
		PreparedStatement statment = connection.prepareStatement(sql);
		ResultSet resultset = statment.executeQuery();
		
		while (resultset.next()) {
			
			BeansCursoJSP beansCursoJsp = new BeansCursoJSP();
			beansCursoJsp.setLogin(resultset.getString("login"));
			beansCursoJsp.setSenha(resultset.getString("senha"));
			
			listar.add(beansCursoJsp);
		}
		
		return listar();
	}
	
	
			
	}

