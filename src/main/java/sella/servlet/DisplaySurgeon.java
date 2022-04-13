package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class DisplaySurgeon
 */
public class DisplaySurgeon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplaySurgeon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();  
		response.setContentType("text/html");  
		out.println("<html><body>");  
		try 
		{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");  
			Statement stmt = con.createStatement();  
			ResultSet rs = stmt.executeQuery("select name,designation from surgeon"); 
			out.println("<style>.form{margin-top:100px;</style>");
			out.println("<body style=\"background-color:powderblue;\">\r\n ");
			out.println(" <div align=\"center\" class=\"form\">");
	           out.println("<h2>Surgeon Details</h2>");

			out.println("<body><table border=1 width=50% height=15% bgcolor='lightgrey'>");  
			out.println("<tr><th>Name</th><th>Designation</th></tr>");  
			while (rs.next()) 
			{  
				String name= rs.getString("name");  
				String dob = rs.getString("designation");  
				out.println("<tr><td>" + name + "</td><td>" + dob + "</td></tr>" );   
			}  
			out.println("</table>"); 
			out.println("<br><br><a href=\"AddSurgeon.html\">Click here To Add</a>");

			out.println("<br><br><a href=\"Surgeon.html\">Previous</a>");
			out.println("</html></body>");  
			con.close();  
		}  
		catch (Exception e) 
		{  
			out.println("error!");  
		} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
