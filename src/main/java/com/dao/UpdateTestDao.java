package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.DiagnosisBean;

public class UpdateTestDao {
	public int updateTest(DiagnosisBean employee) throws ClassNotFoundException {
        String update = "update diagnosis set test=? where pname=?";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
              //"jdbc:mysql://localhost:3306/selladb";
            PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, employee.getTest());
            preparedStatement.setString(2, employee.getPname());

          
           // System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
           connection.close();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return result;
    }


}
