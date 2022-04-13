package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.SurgeonBean;
import com.dao.AddPatientDao;
import com.dao.AddSurgeonDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddSurgeon
 */
public class AddSurgeon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AddSurgeonDao addsurgeondao;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSurgeon() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	addsurgeondao=new AddSurgeonDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		 String name = request.getParameter("name");
	        String designation = request.getParameter("designation");

	     
	        SurgeonBean employee = new SurgeonBean();
	      
	        employee.setName(name);
	        employee.setDesignation(designation);

	       try {
	    	  int status= addsurgeondao.registerSurgeon(employee);
	    	  if(status>0) {
					response.sendRedirect("SurgeonDetailAdded.jsp");

	    	  }else
	    		  out.println("Invalid input!");
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
