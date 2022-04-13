package sella.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import com.bean.LoginBean;
import com.dao.LoginDao;
import com.dao.RegisterDao;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
* Servlet implementation class Register
*/
public class Register extends HttpServlet {
private static final long serialVersionUID = 1L;
private RegisterDao registerdao;



/**
* @see HttpServlet#HttpServlet()
*/
public Register() {
super();
// TODO Auto-generated constructor stub
}
public void init() {
registerdao=new RegisterDao();
}



/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// TODO Auto-generated method stub
      	PrintWriter out=response.getWriter();
        String name=request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

         LoginBean employee = new LoginBean();
         
         employee.setName(name);

         employee.setUsername(username);
         employee.setPassword(password);

       try {
           int status=registerdao.registerEmployee(employee);
            if(status>0) {
	        response.sendRedirect("RegisterSucess.jsp");

            }else
	        out.println("<html><body><h2>Username already Exist</h2></body></html>");
            out.println("<a href=\"Login.html\">previous</a>");
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