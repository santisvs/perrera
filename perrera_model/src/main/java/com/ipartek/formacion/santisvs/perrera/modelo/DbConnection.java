package com.ipartek.formacion.santisvs.perrera.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Clase que permite conectar con la base de datos
 *
 * @author Santisvs
 *
 */
public class DbConnection {
	private final static Logger log = Logger.getLogger(DbConnection.class);
	/** Parametros de conexion */
	private static String bd = "santisvs", login = "root", password = "",
			url = "jdbc:mysql://localhost/" + bd;

	private Connection connection = null;

	/**
	 * Constructor de DbConnection
	 *
	 * @throws SQLException
	 */
	public DbConnection() throws SQLException {
		try {
			// obtenemos el driver de para mysql
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			log.error("Falta el driver mysql");
			throw new SQLException("Falta el driver mysql");
		}
		// obtenemos la conexión
		connection = DriverManager.getConnection(url, login, password);
		log.trace("Conexión a base de datos " + bd + " OK\n");
	}

	/** Permite retornar la conexión */
	public Connection getConnection() {
		return connection;
	}

	/** Permite eliminar la conexión */
	public void desconectar() {
		connection = null;
	}
}