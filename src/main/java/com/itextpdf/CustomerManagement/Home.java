

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Home")
public class Home extends HttpServlet {
	
     
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		System.out.println("service executed");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		
		String name = "NA";
		
	   name = request.getParameter("txtname");
	  String email = request.getParameter("txtemail");
	
		HttpSession session = request.getSession();
		name = (String)session.getAttribute("txtname");
		String Email = (String)session.getAttribute("txtemail");
		String Age = (String)session.getAttribute("txtage");
		
		
		//session.getId();
		//session.invalidate(); // clear your data in session
		
		out.print("Welcome Home Dear "+name+" "+Email+" "+Age+" <br/>");
		out.print("<i>Its: "+new Date()+"</i><br/><br/>");
		
		
	
		
	}
	}


