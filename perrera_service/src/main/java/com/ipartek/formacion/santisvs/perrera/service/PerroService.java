package com.ipartek.formacion.santisvs.perrera.service;

import java.util.List;

import com.ipartek.formacion.santisvs.perrera.pojo.Perro;

/**
 * Interfaz PerroServicio
 *
 * Refleja las operaciones que puede ejecutar este servicio. El objetivo del
 * servicio es servir a distintos clientes. Para poder ejecutar dicho servicio,
 * utiliza la capa modelo.
 *
 * El servicio implementa las operaciones CRUD
 *
 *
 *
 * @author Santisvs
 *
 */
public interface PerroService {

	/**
	 * Coleccion de Perro, limitado a las últimas 500
	 *
	 * @return @{code List<Perro>} listado perros, si no existe lista vacia
	 */
	List<Perro> listar();

	/**
	 * Incluir un @{code Perro} en el sistema
	 *
	 * @param p
	 * @{code Perro}
	 * @return True si el perro se ha incluido correctamente en la perrera.
	 *         False en otro caso
	 */
	boolean insertar(Perro p);

	/**
	 * Eliminar un @{code Perro} del sistema
	 *
	 * @param p
	 * @{code Perro}
	 * @return True si el perro se ha eliminado correctamente de la perrera.
	 *         False en otro caso
	 */
	boolean eliminar(Perro p);

	/**
	 * Modifica los datos del sistema del @{code Perro} que esta como parametro
	 * de entrada
	 *
	 * @param p
	 * @{code Perro}
	 * @return True si el perro se ha eliminado correctamente de la perrera.
	 *         False en otro caso
	 */
	boolean modificar(Perro p);

	/**
	 * Nos muestra los datos del @{code Perro} buscado por su identificador
	 *
	 * @{code id}
	 *
	 * @param id
	 * @{code int}
	 * @return Devuelve el @{code Perro} que corresponde con el @{code id} en la
	 *         BBDD
	 */
	Perro detalle(int id);

	/**
	 * Nos indica si el @{code Perro} con id existe en BBDD
	 *
	 * @{code id}
	 *
	 * @param id
	 * @{code int}
	 * @return True si existe y False si no existe
	 */
	boolean existe(int id);

	/**
	 * Busca perro por cualquier propiedad
	 *
	 * @param criterio
	 *            {@code String} cadena alfanumerica, no permite expresiones
	 *            regulares
	 * @return {@code List<Perro>} listado de perros que coincidan con el
	 *         criterio
	 */
	List<Perro> buscar(String criterio);

}
