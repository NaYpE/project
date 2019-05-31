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
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props = new Properties();
		String archivo = "config.properties";
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream(archivo);
		PrintWriter out = response.getWriter();
		if(inputStream != null) {
			props.load(inputStream);
		}else {
			throw new FileNotFoundException("Property file "+ archivo +" no se encontró en el classPath");
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
		String password2 = request.getParameter("txtPassword2");
		
		int nRegistros = 0;
		RequestDispatcher dis;
		Connection conn = null;
		HttpSession objetoSesion=request.getSession(true);  
		
		Pattern p = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
		Matcher m = p.matcher(correo);
		
        if(nombre.isEmpty() || nombre.isEmpty() || password.isEmpty() || password2.isEmpty()){
        	objetoSesion.setAttribute("error", "Hay campos vacios");
        }else {        
	    	if(password.equals(password2)) {
	    		if(password.length() >= 8) {
	    			
	    			try {
	    				
	    				Class.forName(driver).getDeclaredConstructor().newInstance();
	    				conn = DriverManager.getConnection(urlServidor, usuario, passw);
	    				
	    				String query ="INSERT INTO ciudad_judicial.usuarios (nombreUsuario, apellidoPUsuario, apellidoMUsuario, fechaNacimientoUsuario, sexoUsuario, emailUsuario, passwordUsuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
	    				
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
	    					dis = request.getRequestDispatcher("index.html");
	    					dis.include(request, response);
	    				}else {
	    					
	    					dis = request.getRequestDispatcher("signUp.html");
	    					out.println("<script type:\"text/javascript\">");
	    					out.println("alert('Registro no añadido. Intente de nuevo')");
	    					out.println("location='signUp.html'");
	    					out.println("</script>");
	    					dis.include(request, response); 
	    				}
	    				
	    			} catch (Exception e) {
	    				
	    				e.printStackTrace();
	    			}finally {
	    				try {
	    					conn.close();
	    				} catch (SQLException e) {
	    					// TODO Auto-generated catch block
	    					e.printStackTrace();
	    				}
	    			}
	    			
	    		}else {
	    			dis = request.getRequestDispatcher("signUp.html");
					out.println("<script type:\"text/javascript\">");
					out.println("alert('Registro no añadido. PASSWORD MINIMO 8 CARACTERES')");
					out.println("location='signUp.html'");
					out.println("</script>");
					dis.include(request, response);
	    		}
	    	}else {
	    		dis = request.getRequestDispatcher("signUp.html");
				out.println("<script type:\"text/javascript\">");
				out.println("alert('Registro no añadido. LAS CONTRASEÑAS NO COINCIDEN')");
				out.println("location='signUp.html'");
				out.println("</script>");
				dis.include(request, response);
	    	}
        }
	}
}
