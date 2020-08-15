package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeansCursoJSP;
import dao.DaoUsuario;


@WebServlet("/salvarUsuario")
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private DaoUsuario daoUsuario = new DaoUsuario();
	
	
    public Usuario() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//exclusão
		String acao = request.getParameter("acao");
		String user = request.getParameter("user");
		
		try {
		if (acao.equalsIgnoreCase("delete")) {
			daoUsuario.delete(user);
			//refaz a listagem
			RequestDispatcher view = request.getRequestDispatcher("cadastrousuario.jsp");
			request.setAttribute("usuarios", daoUsuario.listar());
			view.forward(request, response);
		} 
		
		else if (acao.equalsIgnoreCase("editar")) {
			
			BeansCursoJSP beansCursoJSP = daoUsuario.consultar(user);
			
			//refaz a listagem
			RequestDispatcher view = request.getRequestDispatcher("cadastrousuario.jsp");
			request.setAttribute("user", beansCursoJSP);
			view.forward(request, response);
		
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		BeansCursoJSP usuario = new BeansCursoJSP();
		usuario.setId(Long.parseLong(id));
		usuario.setLogin(login);
		usuario.setSenha(senha);
		
		if (id == null || id.isEmpty()){
			
			daoUsuario.salvar(usuario);
		}else {
			daoUsuario.atualizar(usuario);
		}
		
		
		
		// direciona para o cadastro do usuario lista
		
		try {
		RequestDispatcher view = request.getRequestDispatcher("cadastrousuario.jsp");
		request.setAttribute("usuarios", daoUsuario.listar());
		view.forward(request, response);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
