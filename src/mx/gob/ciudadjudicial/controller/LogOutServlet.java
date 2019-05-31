package mx.gob.ciudadjudicial.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mx.gob.ciudadjudicial.model.UsuariosTemp;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/LogOutServlet")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("index.html").include(request, response);  
          
        HttpSession objetoSesion=request.getSession(true);  
        UsuariosTemp user = new UsuariosTemp();
        String nombre = user.getNombre();
        request.setAttribute("user", nombre);
        
        objetoSesion.invalidate();  
        
		RequestDispatcher dis = request.getRequestDispatcher("index.html");
		out.println("<script type:\"text/javascript\">");
		out.println("alert('Has cerrado sesión satisfactoriamente!')");
		out.println("location='index.html'");
		out.println("</script>");
		dis.include(request, response); 
          
        //out.print("You are successfully logged out!");  
          
        out.close();
	}

}
