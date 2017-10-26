

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
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
		
		
		String Name= request.getParameter("txtname");
		String Email= request.getParameter("txtemail");
		String Password= request.getParameter("txtpassword");
		String CnfPassword= request.getParameter("txtconfirmpassword");
		String Age= request.getParameter("txtage");
		String Phone= request.getParameter("txtphone");
		
		// Object shall contain data -> Model
		
		Registration register = new Registration();

		register.setName(Name);
		register.setEmail(Email);
		register.setPassword(Password);
		register.setCnfPassword(CnfPassword);
		register.setAge(Age);
		register.setPhone(Phone);
		
		
		// Object is temporary. Its available in Heap area of RAM.
				// Lets Persist the Object in DB
				JDBCHelper helper = new JDBCHelper();
				helper.openConnection();
				int i = helper.registerUser(register);
				if(i>0){
				 out.print("You are Registered Successfully....");
					
									
				}else{
					out.print("You are not Registered Successfully....");
				}
				helper.closeConnection();
			}




	}

