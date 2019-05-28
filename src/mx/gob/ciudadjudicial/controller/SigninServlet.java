package mx.gob.ciudadjudicial.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

/**
 * Servlet implementation class SignInServlet
 */
@WebServlet("/SigninServlet")
public class SigninServlet extends HttpServlet {
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
		
		String nombre = request.getParameter("txtNombre");
		String apellidoP = request.getParameter("txtApellidoP");
		String apellidoM = request.getParameter("txtApellidoM");
		String fechaNacimiento = request.getParameter("txtBirth"); 
		String sexo = request.getParameter("txtSexo");
		String correo = request.getParameter("txtCorreo");
		String password = request.getParameter("txtPassword");
		int nRegistros = 0;
		
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, usuario, passw);
			
			String query ="INSERT INTO ciudad_judicial.usuarios (nombre, apellidoP, apellidoM, fechaNacimiento, sexo, email, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmnt = conn.prepareStatement(query);
			pstmnt.setString(1, nombre);
			pstmnt.setString(2, apellidoP);
			pstmnt.setString(3, apellidoM);
			pstmnt.setString(4, fechaNacimiento);
			pstmnt.setString(5, sexo);
			pstmnt.setString(6, correo);
			pstmnt.setString(7, password);
			
			nRegistros = pstmnt.executeUpdate();
			
			if(nRegistros > 0) {
				
				response.getWriter().append("Registro a�adido");
			}else {
				response.getWriter().append("Registro NO a�adido");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
