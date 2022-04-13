package com.sella.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet Filter implementation class AuthenticationLogin
 */
public class AuthenticationLogin extends HttpFilter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public AuthenticationLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		String username=request.getParameter("username");
		String password=request.getParameter("password");

		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        //com.mysql.cj.jdbc.Driver

        try {Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");

		PreparedStatement ps = connection.prepareStatement("select username,password from login where username=? and password=?");
		ps.setString(1,username);
		ps.setString(2,password);
		ResultSet rs = ps.executeQuery();

		if(rs.next() && (rs.getString("username").equals(username) && rs.getString("password").equals(password))) {
		chain.doFilter(request, response);
		}
		else {
		session.setAttribute("loginStatus", "failure");
		res.sendRedirect("NewFile.jsp");
		// request.getRequestDispatcher("login.jsp").forward(request, response);

		}


		} catch (Exception e) {
		// TODO: handle exception
		System.err.println(e);
		}



		// pass the request along the filter chain
		}



		/**
		* @see Filter#init(FilterConfig)
		*/
		public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		}



		}