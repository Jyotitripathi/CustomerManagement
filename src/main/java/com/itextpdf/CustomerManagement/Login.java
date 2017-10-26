

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/Login")
public class Login extends HttpServlet {

	
	public void init(ServletConfig config) throws ServletException {
	     System.out.println("init executed");
	}

	
	public void destroy() {
		System.out.println("destroy executed");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         System.out.println("service executed");
		 
		 response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		 
		 String Email = request.getParameter("txtemail");
		 String Password = request.getParameter("txtpassword");
		 
		Registration register = new Registration();
		 register.setEmail(Email);
		 register.setPassword(Password);
		 
		 // Use JDBC HELPER
		 
		 JDBCHelper helper = new JDBCHelper();
		 helper.openConnection();
		boolean check = helper.loginRegister(register);
		String name = "NA";
		
		// check for email and password in DB
		if(check){
			out.println("<b>Login is Success..</b>");
			
			HttpSession session = request.getSession();
			session.setAttribute("txtname", name);
			session.setAttribute("txtemail", Email);
			session.setAttribute("txtage", String.valueOf(30));
			out.println("<a href='Home'>Enter Home</a>");
			
			
		}else{
			out.println("<b>Login is Failure..</b>");
			
		}
		
		helper.closeConnection();
	}
			
	}

