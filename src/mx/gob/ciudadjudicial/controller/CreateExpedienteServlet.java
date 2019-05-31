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

		String expediente = request.getParameter("txtExpe");
	    String tomo = request.getParameter("txtTomo"); 
	    String partidojudicial = request.getParameter("txtPArtidoJudicial"); 
	    String juzgado = request.getParameter("txtbrowser"); 
	    String claseJuicio = request.getParameter("txtJuicio");
	    String actor = request.getParameter("txtActor"); 
	    String abogadoPatrono = request.getParameter("txtAbogadoPat");
	    String autorizados = request.getParameter("txtAutorizados"); 
	    String demandado = request.getParameter("txtDemandado"); 
	    String abogadoPatrono2= request.getParameter("txtAbogadoPat2"); 
	    String autorizados2= request.getParameter("txtAutorizados2"); 
	    String juez= request.getParameter("txtJuez"); 
	    String srio= request.getParameter("txtSrio"); 
	    String fecha= request.getParameter("txtBirth"); 

		int nRegistros = 0;
		Connection conn = null;
		
		try {
			
			Class.forName(driver).getDeclaredConstructor().newInstance();
			conn = DriverManager.getConnection(urlServidor, usuario, passw);
			
			String query ="INSERT INTO ciudad_judicial.expedientes ("
					+ "num_expediente,"
					+ "tomo,"
					+ "partido_judicial_expediente,"
					+ "juzgado_expediente,"
					+ "tipo_juicio_expediente,"
					+ "actor_expediente,"
					+ "abogado_patrono,"
					+ "autorizados,"
					+ "demandado_expediente,"
					+ "abogados_patrono_dos,"
					+ "autorizados_dos,"
					+ "juez_expediente,"
					+ "srio_lic,"
					+ "fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmnt = conn.prepareStatement(query);
			
			pstmnt.setString(1, expediente);
			pstmnt.setString(2, tomo);
			pstmnt.setString(3, partidojudicial);
			pstmnt.setString(4, juzgado);
			pstmnt.setString(5, claseJuicio);
			pstmnt.setString(6, actor);
			pstmnt.setString(7, abogadoPatrono);
			pstmnt.setString(8, autorizados);
			pstmnt.setString(9, demandado);
			pstmnt.setString(10, abogadoPatrono2);
			pstmnt.setString(11, autorizados2);
			pstmnt.setString(12, juez);
			pstmnt.setString(13, srio);
			pstmnt.setString(14, fecha);
			
			
			
			
			
			
			
			
			nRegistros = pstmnt.executeUpdate();
			
			if(nRegistros > 0) {
		
				RequestDispatcher dis = request.getRequestDispatcher("homeCJ.html");
				dis.include(request, response); 
				
			}else {
				
				PrintWriter out = response.getWriter();
				RequestDispatcher dis = request.getRequestDispatcher("expediente.html");
				out.println("<script type:\"text/javascript\">");
				out.println("alert('Registro no añadido. Intente de nuevo')");
				out.println("location='expediente.html'");
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
		
	}
		
	}

	