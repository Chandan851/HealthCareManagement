package sella.servlet;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DisplayPatients
 */
public class DisplayPatients extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayPatients() {
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
            ResultSet rs = stmt.executeQuery("select id,name,dob,doa,gender from patients order by id asc"); 
          out.println("<style>.form{margin-top:100px;</style>");
         out.println("<body style=\"background-color:powderblue;\">\r\n ");
            out.println(" <div align=\"center\" class=\"form\">");
           out.println("<h2>Pateints Details</h2>");
            out.println("<body><table border=1 width=50% height=15% bgcolor='lightgrey'>");  
            out.println("<tr><th>Id</th><th>Name</th><th>Date of birth</th><th>Date of admission</th><th>Gender</th><tr>");  
            while (rs.next()) 
            {  
            	int id=rs.getInt("id");
                String name= rs.getString("name");  
                String dob = rs.getString("dob"); 
                String doa = rs.getString("doa");  

                String gender = rs.getString("gender");   
                out.println("<tr><td>" + id + "</td><td>"+ name + "</td><td>" + dob + "</td><td>"+ doa + "</td><td>" + gender + "</td></tr>");   
            }  
            out.println("</table>"); 
            out.println("<br><br><a href=\"AddPatients.jsp\">Click Here to add</a>");

            out.println("<br><br><a href=\"RemovePatientDetail.html\">Click here to Remove</a>");

            out.println("<br><br><a href=\"Patient.html\">Back</a>");

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
