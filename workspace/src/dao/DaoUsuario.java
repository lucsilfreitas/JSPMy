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
		
		return listar;
	}
	
	public void delete (String login) {
		
		try {
		String sql = "delete from usuario where login = '" + login +"'";
		PreparedStatement preparedStatement =  connection.prepareStatement(sql);
		preparedStatement.execute();
		connection.commit();
		
		}catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
	}
	
	//update do registro
	
	public BeansCursoJSP consultar(String login) throws Exception {
		
		String sql = "select * from usuario where login='" + login +"'";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
	
		if (resultSet.next()) {
			
			BeansCursoJSP beansCursoJSP = new BeansCursoJSP();
			
			beansCursoJSP.setLogin(resultSet.getString("login"));
			beansCursoJSP.setSenha(resultSet.getString("senha"));
			
			return beansCursoJSP;
			
		}
		
		return null;
		
		
	}
	
	public void atualizar(BeansCursoJSP usuario) {
		try {
			String sql = "update usuario set login = ?. senha = ? where id = " + usuario.getId();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, usuario.getLogin());
			preparedStatement.setString(2, usuario.getSenha());
			preparedStatement.execute();
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
		
	}
			


