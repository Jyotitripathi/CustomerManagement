

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.TryCatchFinally;

import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.eclipse.jdt.internal.compiler.ast.TryStatement;


public class JDBCHelper {
	
	Connection con;
	PreparedStatement pStmt;
	
	public JDBCHelper() {
		try {
			//1. Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("--Driver Loaded--");
		} catch (Exception e) {
			
			System.out.println("Some Exception: "+e);
		}

}
	
	public void openConnection(){
		try {
			
			//2. Create the Connection
			String url = "jdbc:mysql://localhost/tables";
			String user = "root";
			String pass = "";
			
			con = DriverManager.getConnection(url, user, pass);
			System.out.println("--Connection Created--");
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
	}
	
public int registerUser(Registration register){
		
		int i = 0;
		
		try {
			//3. Create SQL Statement
			String sql = "insert into project values(null, ?, ?, ?,?,?,?)";
			pStmt = con.prepareStatement(sql);
			pStmt.setString(1,  register.getName());
			pStmt.setString(2,  register.getEmail());
			pStmt.setString(3,  register.getPassword());
			pStmt.setString(4,  register.getCnfPassword());
			pStmt.setString(5,  register.getAge());
			pStmt.setString(6,  register.getPhone());
			
			
			
			//4. Execute SQL Statement
			i = pStmt.executeUpdate();
			if(i>0){
				System.out.println( register.getName()+" Registered");
			}else{
				System.out.println( register.getName()+" not Registered");
			}
			
		} catch (Exception e) {
			System.out.println("Some Exception: "+e);
		}
		
		return i;
	}

public void incrementpoints(String Email) {
	      
	int i=0;
	int points = getpoints(Email);
	
	points= points+2;	
	
	try {
		
		String sql = "update project set POINTS=? where EMAIL=?";
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, String.valueOf(points) );
		pStmt.setString(2, Email);
		
		i = pStmt.executeUpdate();
		if(i>0)
		{
			System.out.println("points updated");
		}
		else {
			System.out.println("points didn't updated");
		}
		
	} catch (Exception e) {
		
	e.printStackTrace();
	}
}


public int getpoints(String email) {

	int points=-1;
	try {
		
		String sql = "select POINTS from project where email=?";
		
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, email);
		
		ResultSet rs = pStmt.executeQuery();
		boolean userexist = rs.next();
		if(userexist)
		{ System.out.print("exist");
			points = Integer.valueOf(rs.getString(1));
		}
		
	} catch (Exception e) {
       System.out.println("Some Exception: "+e);	e.printStackTrace();	
	}
	
	return 0;
}

public boolean loginRegister(Registration register){
	boolean login = false;
	try{
		//3. Create SQL Statement
		String sql = "select * from project where email = ? and password = ?";
		pStmt = con.prepareStatement(sql);
		pStmt.setString(1, register.getEmail());
		pStmt.setString(2, register.getPassword());
		
		ResultSet rs = pStmt.executeQuery();
		
		login = rs.next();
		
	}catch (Exception e) {
		System.out.println("Some Exception: "+e);

	}
	return login;
}

public ArrayList retrieveUsers()
{
	ArrayList<String> userslist = new ArrayList<String>();
	
	try {
		
		String sql = "select EMAIL from project";
		pStmt = con.prepareStatement(sql);
		ResultSet rs = pStmt.executeQuery();
		
		
		while(rs.next())
		{
			if(!rs.getString(1).equals("jyoti@example.com"))
			{
				userslist.add(rs.getString(1));
			}
			
		}
	} catch (Exception e) {
		System.out.println(e.getMessage());

	}
	return userslist;
	
}

public void closeConnection(){
	try {
		pStmt.close();
		con.close();
	} catch (Exception e) {
		System.out.println("Some Exception: "+e);
	}
	
}
}


