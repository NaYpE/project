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

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


import mx.gob.ciudadjudicial.model.Expedientes;

	

@WebServlet("/CreateExpedienteServlet")
@MultipartConfig

public class CreateExpedienteServlet extends HttpServlet {
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

		
		Gson objGson = new Gson();
		Expedientes miExpediente ;
		String jsonExpediente;
		jsonExpediente = request.getParameter("txtExpediente");
		miExpediente = objGson.fromJson(jsonExpediente, Expedientes.class);

		int nRegistros = 0;
		Connection conn = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, usuario, passw);
			
			String query ="INSERT INTO judicial.expedientes (idExpedientes,actor_expediente,demandante_expediente,tipo_juicio_expediente,num_expediente,tomo,abogado_patrono,autorizados,fecha,abogado_patrono_dos,autorizados_dos,juez_expediente,juzgado_expediente,srio_lic) VALUES (0,?,?,?,?, ?, ?, ?, ?, ?, ?,?,?,?)";
			
			PreparedStatement pstmnt = conn.prepareStatement(query);
			
			
			pstmnt.setString(1, miExpediente.getActor());
			pstmnt.setString(2, miExpediente.getDemandado());
			pstmnt.setString(3, miExpediente.getPartidojuicio());
			pstmnt.setInt(4, miExpediente.getExpediente());
			pstmnt.setString(5, miExpediente.getTomo());
			pstmnt.setString(6, miExpediente.getAbogadoPatrono());
			pstmnt.setString(7, miExpediente.getAutorizados());
			pstmnt.setString(8, miExpediente.getFecha());
			pstmnt.setString(9, miExpediente.getAbogadoPatrono2());
			pstmnt.setString(10, miExpediente.getAutorizados2());
			pstmnt.setString(11, miExpediente.getJuez());
			pstmnt.setString(12, miExpediente.getJuzgado());
			pstmnt.setString(13, miExpediente.getSrio());
			
			
			
					nRegistros = pstmnt.executeUpdate();
			
			if(nRegistros > 0) {
		
				response.sendRedirect("home.html");
			}else {
				PrintWriter out = response.getWriter();
				RequestDispatcher dis = request.getRequestDispatcher("signUp.html");
				out.println("<script type:\"text/javascript\">");
				out.println("alert('Registro no añadido. Intente de nuevo')");
				out.println("location='expediente.html'");
				out.println("</script>");
				dis.include(request, response); response.getWriter().append("Registro NO añadido");
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
		
	}
		
	}

	