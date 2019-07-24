package com.web.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
private static String DATABASE_URL = "jdbc:oracle:thin:@172.17.42.63:1521:orclupsoltp";
private static String DATABASE_USER = "p54g7_oltp_na";
private static String DATABSE_PASSWORD = "g07_4263";

	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet resultSet = null;

	private static boolean conectada = false;

	public static void conectar() {
		try {
			connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABSE_PASSWORD);
			conectada = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public  ResultSet consultar(String sentencia) {
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sentencia);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultSet;

	}

	public static int ejecutar(String sentencia) {
		int r = 0;
		try {
			statement = connection.createStatement();
			r = statement.executeUpdate(sentencia, Statement.RETURN_GENERATED_KEYS);
			resultSet = statement.getGeneratedKeys();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	public static void cerrar() {

		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}

			if (connection != null) {
				connection.close();
			}
			conectada = false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static ResultSet getResultSet() {
		return resultSet;
	}

	public static boolean isConectada() {
		return conectada;
	}



	
}

