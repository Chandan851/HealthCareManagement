package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.PatientBean;
import com.dao.AddPatientDao;
import com.dao.RemovePatientDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RemovePatient
 */
public class RemovePatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RemovePatientDao removepatientdao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemovePatient() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	removepatientdao=new RemovePatientDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NumberFormatException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
            String id=request.getParameter("id");
		     
	        PatientBean employee = new PatientBean();
	      
	        employee.setId(id);
	      

	       try {
	    	   int status=removepatientdao.removePatient(employee);
	    	   if(status>0) {
					response.sendRedirect("PatientRemoved.jsp");

	    	   }else
	    		   out.println("<h2>Invaid input!</h2>");
	    	   out.println("<a href=\"Patient.html\">Previous</a>");
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
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
