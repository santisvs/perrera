package com.ipartek.formacion.santisvs.perrera;

/**
 * Clase Constantes que guarda todas las variables globales que utilizaremos en
 * la capa servicio
 *
 * @author Santisvs
 *
 */
public class Constantes {

	// Generales
	public static final String APP_NAME = "perrera";
	// public static final String SERVER = "http://localhost:8080/";
	public static final String ROOT = /* SERVER + */"/" + APP_NAME + "/";

	// OPERACIONES CONTROLADORES
	public static final int OP_NUEVO = 0;
	public static final int OP_DETALLE = 1;
	public static final int OP_LISTAR = 2;
	public static final int OP_MODIFICAR = 3;
	public static final int OP_ELIMINAR = 4;

	// RESULTADO DE OPERACIONES EN BBDD
	public static final int OP_EXCEPCION = -1;
	public static final int OP_NO_REALIZADA = 0;
	public static final int OP_OK = 1;

	// CONTROLADORES

	public static final String CONTROLLER_PERROS = "perros";

	// VISTAS

	public static final String VIEW_PERRO_LIST = "/pages/perros/perros.jsp";
	public static final String VIEW_PERRO_FORM = "/pages/perros/perroDetalle.jsp";

}
