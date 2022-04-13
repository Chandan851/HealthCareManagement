package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.DiagnosisBean;
import com.dao.AddDiagnosisDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddDiagnosis
 */
public class AddDiagnosis extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddDiagnosisDao adddiagnosis;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddDiagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() {
		adddiagnosis=new AddDiagnosisDao();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();

		String test = request.getParameter("test");
		String pname = request.getParameter("pname");
		String sname = request.getParameter("sname");
		String ordate = request.getParameter("ordate");
		String resdate = request.getParameter("resdate");


		DiagnosisBean employee = new DiagnosisBean();

		employee.setTest(test);
		employee.setPname(pname);
		employee.setSname(sname);
		employee.setOrdate(ordate);
		employee.setResdate(resdate);


		try {
			int status=adddiagnosis.registerDiagnosis(employee);
			if(status>0) {
				request.getRequestDispatcher("DiagnosisAddedSucess.jsp").forward(request, response);

			}else
				out.println("Invalid Input");
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
