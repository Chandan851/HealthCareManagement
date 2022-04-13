package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.SurgeonBean;

public class AddSurgeonDao {
	public int registerSurgeon(SurgeonBean employee) throws ClassNotFoundException {
		String INSERT_USERS_SQL = "insert into surgeon values(?,?)";

		int result = 0;

		Class.forName("com.mysql.cj.jdbc.Driver");

		try {Connection connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/selladb", "root", "1234");
		//"jdbc:mysql://localhost:3306/selladb";
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
		//  preparedStatement.setInt(1, 1);
		preparedStatement.setString(1, employee.getName());
		preparedStatement.setString(2, employee.getDesignation());


		// System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
        connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
