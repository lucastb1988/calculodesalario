package br.com.calculodesalario.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoUtil {
	
	public static void closeConnection(Connection connection, PreparedStatement ps, ResultSet rs) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}

		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
		
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.getMessage();
			}
		}
	}
}
