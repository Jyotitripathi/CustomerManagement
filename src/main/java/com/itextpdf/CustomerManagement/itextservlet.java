

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/itextsservlet")
public class itextservlet extends HttpServlet {
	
	public static final String DEST = "E:/lucky-I.T/JAVA Advanced/Eclipse_JEE_Workspace/customer_management_system/src/main/java/pdfoutputs/helloworld.pdf";

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 try {
	        	File file = new File(DEST);
		        file.getParentFile().mkdirs();
		        new itextservlet().createPdf(DEST);
	        }catch (Exception e) {

	        	System.out.println("Exception "+e);
			}
	}
	
	public void createPdf(String dest) throws IOException {
    
		//Initialize PDF writer
     PdfWriter writer = new PdfWriter(dest);

     //Initialize PDF document
     PdfDocument pdf = new PdfDocument(writer);

     // Initialize document
     Document document = new Document(pdf);

     //Add paragraph to the document
     document.add(new Paragraph("Hello World!"));

     //Close document
     document.close();
 }

	}

