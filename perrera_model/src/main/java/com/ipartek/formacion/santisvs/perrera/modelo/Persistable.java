package com.ipartek.formacion.santisvs.perrera.modelo;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaz para dar la habilidad de que sean Persistables los DAOs.<br>
 * Se encarga de que se implementen las operaciones mas basicas de CRUD.
 *
 * @param <P>
 *            Clase generica la que luego sustituimos por nuestra clase
 *            concreta, por ejemplo <code>Perro</code>
 *
 * @author Santisvs
 *
 */
public interface Persistable<P> {

	/**
	 * Listado de todos los objetos de la consulta ordenado por id descente,
	 * limitado a 500
	 *
	 * @return {@code List
	 * <P>} si existen datos, en caso contrario {@code List} inicialiazada
	 * @throws SQLException
	 */
	List<P> getAll() throws SQLException;

	/**
	 * Busca un objeto en la tabla por su identificacor
	 *
	 * @param id
	 *            {@code int} identificador del objeto
	 * @return Objeto generico, {@code null} si no existe
	 * @throws SQLException
	 */
	P getById(int id) throws SQLException;

	/**
	 * Elimina objeto de la tabla
	 *
	 * @param id
	 *            {@code int} identificador del objeto
	 * @return true si elimina, false en caso contrario
	 * @throws SQLException
	 */
	boolean delete(int id) throws SQLException;

	/**
	 * Modifica el objeto solicitado
	 *
	 * @param persistable
	 *            {@code P} Objeto con los valores a modicar
	 * @return true si modifica, false en caso contrario
	 * @throws SQLException
	 */
	boolean update(P persistable) throws SQLException;

	/**
	 * Inserta un nuevo objeto
	 * 
	 * @param persistable
	 *            {@code P} Objeto a insertar
	 * @return {@code int} identificador del objeto insertado, -1 en caso
	 *         contrario
	 * @throws SQLException
	 */
	int insert(P persistable) throws SQLException;
}
