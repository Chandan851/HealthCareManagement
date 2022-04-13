package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.LoginBean;

public class LoginDao {
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.cj.jdbc.Driver");
        //com.mysql.cj.jdbc.Driver

        try {Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
      //"jdbc:mysql://localhost:3306/selladb","root","1234"

            PreparedStatement preparedStatement = connection
            .prepareStatement("select username,password from login where username = ? and password = ? "); {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());

            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
            //System.out.println("Status : "+status);
            connection.close();

            }
        } catch (SQLException e) {
           e.printStackTrace();  
           }
        return status;
    

	}

	

	public static PreparedStatement getPreparedStatement(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
