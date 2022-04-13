package sella.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.bean.LoginBean;
import com.dao.LoginDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private LoginDao logindao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() 	{
        super();
        // TODO Auto-generated constructor stub
    }
public void init() {
	logindao=new LoginDao();
}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		 String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        LoginBean loginBean = new LoginBean();
	        loginBean.setUsername(username);
	        loginBean.setPassword(password);
	        try {
				if (logindao.validate(loginBean)){
				
				    request.getRequestDispatcher("NewFile.jsp").forward(request, response);
				} 
				//request.setAttribute("message", "login unsucces");
				//request.getRequestDispatcher("Login.html").forward(request, response);
				out.println("<body><h2>login Unsucessfull!<h2>");	
				out.println("   <a href=\"Login.html\">go back\r\n ");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
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
