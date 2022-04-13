package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.bean.PatientBean;

public class AddPatientDao {

	public int registerPatient(PatientBean employee) throws ClassNotFoundException ,SQLException{
		String INSERT_USERS_SQL = "insert into patients values(?,?,?,?,?)";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
		//"jdbc:mysql://localhost:3306/selladb";
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
		//  preparedStatement.setInt(1, 1);
		preparedStatement.setString(1, employee.getId());

		preparedStatement.setString(2, employee.getName());

		preparedStatement.setString(3, employee.getDob());
		java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());

		preparedStatement.setDate(4, sqlDate);

		preparedStatement.setString(5, employee.getGender());


		//  System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
        connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}