package mx.gob.ciudadjudicial.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.gob.ciudadjudicial.model.UsuariosTemp;

/**
 * Servlet implementation class BusquedaServlet
 */
@WebServlet("/BusquedaServlet")
public class BusquedaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Properties props = new Properties();
		String archivo = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivo);
		
		if(inputStream != null) {
			props.load(inputStream);
		}else {
			throw new FileNotFoundException("Property file "+ archivo +" no se encontr� en el classPath");
		}
		
		String urlServidor = props.getProperty("urlServidor");
		String usuario = props.getProperty("user");
		String passw = props.getProperty("password");
		String driver = props.getProperty("driver");
		
		String expediente = request.getParameter("txtExp");	
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
		PrintWriter salida = response.getWriter();
		response.setContentType("text/html charset='UTF-8'");
		try {
			
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(urlServidor,usuario,passw);
			stmnt = conn.createStatement();
			rs= stmnt.executeQuery("SELECT * FROM ciudad_judicial.usuarios WHERE (nombreUsuario=\""+ expediente+"\" OR apellidoPUsuario =\""+ expediente +"\")");
			UsuariosTemp users;
			ArrayList<UsuariosTemp> listaUsers = new ArrayList<UsuariosTemp>();
			while (rs.next()) {
				users = new UsuariosTemp(rs.getString("nombreUsuario"),
						rs.getString("apellidoPUsuario"), 
						rs.getString("apellidoMUsuario"),
						rs.getString("fechaNacimientoUsuario"),
						rs.getString("sexoUsuario"),
						rs.getString("emailUsuario"),
						rs.getString("passwordUsuario"));
				listaUsers.add(users);
			}
			request.setAttribute("list", listaUsers);
			RequestDispatcher rst = request.getRequestDispatcher("busqueda.jsp");
			rst.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				rs.close();
				stmnt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		salida.close();
	}

}
