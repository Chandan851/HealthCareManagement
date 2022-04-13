package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.DiagnosisBean;
import com.bean.PatientBean;
import com.dao.UpdateTestDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class UpdateTest
 */
public class UpdateTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UpdateTestDao updatetest;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateTest() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() {
    	updatetest=new UpdateTestDao();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();

		 String test = request.getParameter("test");
	        String pname=request.getParameter("pname");

	     
	        DiagnosisBean employee = new DiagnosisBean();
	      
	        employee.setTest(test);
	        employee.setPname(pname);


	       try {
	    	   int status=updatetest.updateTest(employee);
	    	   if(status>0) {
					response.sendRedirect("UpdateTestSucess.jsp");

	    	   }else
	    		   //out.println("<body><html><div align=\"center\">);
	    	   {out.println("<h2>please enter valid name</h2>");
	    	   out.println("<a href=\"Diagnosis.html\">Previous</a></tr>");
	        } 
	    	//response.sendRedirect("UpdateTest");   
	       }catch (Exception e) {
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
