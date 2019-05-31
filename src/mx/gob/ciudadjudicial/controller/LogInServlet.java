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
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.gob.ciudadjudicial.model.UsuariosTemp;

/**
 * Servlet implementation class LogInServlet
 */
@WebServlet(description = "Servlet para login", urlPatterns = { "/LogInServlet" })
public class LogInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Properties props = new Properties();
		String archivo = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivo);
		
		if(inputStream != null) {
			props.load(inputStream);
		}else {
			throw new FileNotFoundException("Property file "+ archivo +" no se encontró en el classPath");
		}
		
		String urlServidor = props.getProperty("urlServidor");
		String usuario = props.getProperty("user");
		String passw = props.getProperty("password");
		String driver = props.getProperty("driver");
		
		String correo = request.getParameter("txtCorreo");
		String password = request.getParameter("txtPassword");
		String correoSQL = "";
		String passwordSQL = "";
		String nombreSQL = "";
		String apellidoSQL = "";
		
		Connection conn = null;
		Statement stmnt = null;
		ResultSet rs = null;
		
		UsuariosTemp user;
		try {
			
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, usuario, passw);
			stmnt = conn.createStatement();
			
			rs = stmnt.executeQuery("SELECT nombreUsuario, apellidoPUsuario, emailUsuario, passwordUsuario FROM ciudad_judicial.usuarios WHERE emailUsuario = \""+ correo +"\" AND passwordUsuario =\""+ password +"\"");
			
			rs.next();
			
			correoSQL = rs.getString("emailUsuario");
			passwordSQL = rs.getString("passwordUsuario");
			nombreSQL = rs.getString("nombreUsuario");
			apellidoSQL = rs.getString("apellidoPUsuario");
			
			user = new UsuariosTemp(nombreSQL, apellidoSQL);
			
			//request.setAttribute("user", nombreSQL);
			if(correo.equals(correoSQL) && password.equals(passwordSQL)) {
				
				HttpSession objetoSesion = request.getSession(true);
				objetoSesion.setAttribute("Usuario", correo);
				objetoSesion.setAttribute("Password", password);
				objetoSesion.setMaxInactiveInterval(30);
				response.sendRedirect("homeCJ.jsp");
				
			}else {
				
				PrintWriter out = response.getWriter();
				RequestDispatcher dis = request.getRequestDispatcher("index.html");
				out.println("<script type:\"text/javascript\">");
				out.println("alert('Usuario o contraseña no valido, intente de nuevo')");
				out.println("location='index.html'");
				out.println("</script>");
				dis.include(request, response); 
				
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				conn.close();
				stmnt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
