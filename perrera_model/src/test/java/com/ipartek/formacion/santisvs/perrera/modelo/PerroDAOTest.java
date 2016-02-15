package com.ipartek.formacion.santisvs.perrera.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ipartek.formacion.santisvs.perrera.pojo.Perro;

public class PerroDAOTest {

	static DbConnection db;
	static Connection conn;
	static PerroDAO dao;
	static Perro p = null;
	static Perro p1 = null;
	static Perro p2 = null;
	static Perro p3 = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		p = new Perro();
		p1 = new Perro("Perro1", null, null);
		p2 = new Perro("Perro2", null, null);
		p3 = new Perro("Perro3", null, null);
		dao = new PerroDAO();
		try {
			dao.insert(p);
			dao.insert(p1);
			dao.insert(p2);
			dao.insert(p3);
		} catch (SQLException e) {
			fail("Excepcion Base de Datos: " + e.getMessage());
		}
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		try {
			dao.delete(p.getId());
			dao.delete(p1.getId());
			dao.delete(p2.getId());
			dao.delete(p3.getId());
		} catch (SQLException e) {
			fail("Excepcion Base de Datos: " + e.getMessage());
		}
		p = null;
		p1 = null;
		p2 = null;
		p3 = null;
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDataBase() {
		try {
			db = new DbConnection();
			conn = db.getConnection();
			db.desconectar();
		} catch (SQLException e) {
			fail("Excepcion Base de Datos: " + e.getMessage());
		}
	}

	@Test
	public void testInsertar() {
		Perro perro = new Perro("Paris", "Stafford", 'H');

		try {
			int tamaño = dao.getAll().size();
			dao.insert(perro);
			assertEquals("Error en la insercion del registro", tamaño + 1, dao
					.getAll().size());
			dao.delete(perro.getId());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("Excepcion Base de Datos: " + e.getMessage());
		}

	}
}
