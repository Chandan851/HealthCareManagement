package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.DiagnosisBean;


public class AddDiagnosisDao {
	public int registerDiagnosis(DiagnosisBean employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "insert into diagnosis values(?,?,?,?,?)";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
		//"jdbc:mysql://localhost:3306/selladb";
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
		//  preparedStatement.setInt(1, 1);
		preparedStatement.setString(1, employee.getTest());
		preparedStatement.setString(2, employee.getPname());
		preparedStatement.setString(3, employee.getSname());
		preparedStatement.setString(4, employee.getOrdate());
		preparedStatement.setString(5, employee.getResdate());

		// System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
         connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}

