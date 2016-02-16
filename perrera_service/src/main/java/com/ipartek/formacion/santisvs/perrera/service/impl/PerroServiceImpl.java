package com.ipartek.formacion.santisvs.perrera.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ipartek.formacion.santisvs.perrera.Constantes;
import com.ipartek.formacion.santisvs.perrera.modelo.PerroDAO;
import com.ipartek.formacion.santisvs.perrera.pojo.Perro;
import com.ipartek.formacion.santisvs.perrera.service.PerroService;

public class PerroServiceImpl implements PerroService {

	private final static Logger log = Logger.getLogger(PerroServiceImpl.class);

	/*********************************************************
	 *********** CONSTRUCTOR CON PATRÓN SINGLETON ************
	 *********************************************************/
	private static PerroService singleton = null;
	private PerroDAO daoPerro;

	/*
	 * Constructor privado para patrón singleton
	 */
	private PerroServiceImpl() {
		super();
		daoPerro = new PerroDAO();
	}

	/*
	 * Patron de diseño SINGLETON Para que solo se pueda crear un objeto de esta
	 * clase
	 */
	public static PerroService getSingleton() {
		if (singleton == null) {
			singleton = new PerroServiceImpl();
		}
		return singleton;
	}

	/*********************************************************
	 *********** FIN CONSTRUCTOR CON PATRÓN SINGLETON ********
	 *********************************************************/

	@Override
	public List<Perro> listar() {
		ArrayList<Perro> list;
		try {
			list = (ArrayList<Perro>) daoPerro.getAll();
			log.debug("OK: Listado de perros correcto. Tamaño de la lista = "
					+ list.size());
		} catch (Exception e) {
			log.error("Operacion getAll del objeto PerroDAO");
			e.printStackTrace();
			list = new ArrayList<Perro>();
		}
		return list;
	}

	@Override
	public boolean insertar(Perro p) {
		boolean resul = false;
		try {
			if (Constantes.OP_EXCEPCION == daoPerro.insert(p)) {
				log.debug("Error en la insercion PerroDAO - insert(Perro)");
			} else {
				log.debug("OK: Perro insertado correctamente. ID = "
						+ p.getId());
				resul = true;
			}
		} catch (Exception e) {
			log.error("Error en la conexion con BBDD. PerroDAO - insert(Perro)");
			e.printStackTrace();
		}

		return resul;
	}

	@Override
	public boolean eliminar(Perro p) {
		boolean resul = false;
		try {
			if (daoPerro.delete(p.getId())) {
				log.debug("OK: Perro eliminado correctamente. ID = "
						+ p.getId());
				resul = true;
			}
		} catch (Exception e) {
			log.error("Operacion delete del objeto PerroDAO");
			e.printStackTrace();
		}
		return resul;
	}

	@Override
	public boolean modificar(Perro p) {
		boolean resul = false;
		try {
			if (daoPerro.update(p)) {
				log.debug("OK: Perro modificado correctamente. ID = "
						+ p.getId());
				resul = true;
			}
		} catch (Exception e) {
			log.error("Operacion update del objeto PerroDAO");
			e.printStackTrace();
		}

		return resul;
	}

	@Override
	public Perro detalle(int id) {
		Perro p;
		try {
			p = daoPerro.getById(id);
		} catch (Exception e) {
			// TODO Log
			e.printStackTrace();
			p = new Perro();
		}
		return p;
	}

	@Override
	public boolean existe(int id) {
		boolean resul = false;
		Perro p;
		try {
			p = daoPerro.getById(id);
			if (Constantes.OP_EXCEPCION != p.getId()) {
				resul = true;
			}
		} catch (Exception e) {
			// TODO Log
			e.printStackTrace();
			p = new Perro();
		}
		return resul;
	}

	@Override
	public List<Perro> buscar(String criterio) {
		// TODO Auto-generated method stub
		return null;
	}

}
