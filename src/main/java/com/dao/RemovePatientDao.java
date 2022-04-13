package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.PatientBean;

public class RemovePatientDao {
	public int removePatient(PatientBean employee) throws ClassNotFoundException,SQLException {
        String INSERT_USERS_SQL = "delete from patients where id=?";

       int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
              //"jdbc:mysql://localhost:3306/selladb";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, employee.getId());
         
          
           // System.out.println(preparedStatement);
          //  ResultSet rs=preparedStatement.executeUpdate();
            result = preparedStatement.executeUpdate();
           connection.close();
        } catch (NumberFormatException e) {
           e.printStackTrace();
        }
        return result;
    }

}
