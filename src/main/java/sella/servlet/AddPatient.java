package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;

//import com.bean.LoginBean;
import com.bean.PatientBean;
import com.dao.AddPatientDao;
//import com.dao.RegisterDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddPatient
 */
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddPatientDao addpatientdao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPatient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() {
		addpatientdao=new AddPatientDao();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException ,NumberFormatException{
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String id=request.getParameter("id");
		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		String doa = request.getParameter("doa");

		String gender = request.getParameter("gender");


		PatientBean employee = new PatientBean();
		employee.setId(id);

		employee.setName(name);
		employee.setDob(dob);
		employee.setDoa(doa);

		employee.setGender(gender);

		try {
			int status=addpatientdao.registerPatient(employee);
			if(status>0) {
				response.sendRedirect("DetailAdded.jsp");

			}else
			{
				out.println("<html><body><h2>Patient already exist<h2></body></html>");
				out.println("<a href=\"AddPatient\">previous");
			}
		}catch(NumberFormatException e) {
			request.setAttribute("message", "patient already exist..");
			request.getRequestDispatcher("AddPatients.jsp").forward(request, response);
		}

		catch (Exception e) {
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
