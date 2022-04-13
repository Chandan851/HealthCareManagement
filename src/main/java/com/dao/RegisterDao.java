package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import com.bean.LoginBean;

public class RegisterDao {

    public int registerEmployee(LoginBean employee) throws ClassNotFoundException,SQLException {
        String INSERT_USERS_SQL = "insert into login values(?,?,?)";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");

        try {Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
//"jdbc:mysql://localhost:3306/selladb";
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, employee.getName());

            preparedStatement.setString(2, employee.getUsername());
            preparedStatement.setString(3, employee.getPassword());
          
            //System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLIntegrityConstraintViolationException e) {
            result=0;        }
        return result;
    }

}