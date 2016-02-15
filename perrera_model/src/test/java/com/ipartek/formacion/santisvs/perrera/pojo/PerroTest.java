package com.ipartek.formacion.santisvs.perrera.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PerroTest {

	@Test
	public void constructorVacio() {

		Perro p = new Perro();
		assertEquals("No coincide nombre", Perro.NOMBRE_SIN_DEFINIR,
				p.getNombre());
		assertEquals("No coincide raza", Perro.RAZA_SIN_DEFINIR, p.getRaza());
		assertEquals("No el sexo correcto", Perro.SEXO_INDEFINIDO, p.getSexo());

	}

	@Test
	public void constructorConParametros() {

		Perro p = new Perro("Rex", "Chucho", Perro.SEXO_MACHO);
		assertEquals("No coincide nombre", "Rex", p.getNombre());
		assertEquals("No coincide raza", "Chucho", p.getRaza());
		assertEquals("No coincide sexo", Perro.SEXO_MACHO, p.getSexo());

		p = new Perro(null, null, null);
		assertEquals("No coincide nombre", Perro.NOMBRE_SIN_DEFINIR,
				p.getNombre());
		assertEquals("No coincide raza", Perro.RAZA_SIN_DEFINIR, p.getRaza());
		assertEquals("No coincide sexo", Perro.SEXO_INDEFINIDO, p.getSexo());

		p = new Perro("", "", ' ');
		assertEquals("No coincide nombre", Perro.NOMBRE_SIN_DEFINIR,
				p.getNombre());
		assertEquals("No coincide raza", Perro.RAZA_SIN_DEFINIR, p.getRaza());
		assertEquals("No coincide sexo", Perro.SEXO_INDEFINIDO, p.getSexo());

	}

	@Test
	public void setSexoTest() {

		Perro p = new Perro("Rex", "Chucho", "hembra");
		assertEquals("No coincide sexo", Perro.SEXO_HEMBRA, p.getSexo());

		p = new Perro("Rex", "Chucho", "Hembra");
		assertEquals("No coincide sexo", Perro.SEXO_HEMBRA, p.getSexo());

		p = new Perro("Rex", "Chucho", "macho");
		assertEquals("No coincide sexo", Perro.SEXO_MACHO, p.getSexo());

		p = new Perro("Rex", "Chucho", "Macho");
		assertEquals("No coincide sexo", Perro.SEXO_MACHO, p.getSexo());

		p = new Perro("Rex", "Chucho", "cualquier cosa");
		assertEquals("No coincide sexo", Perro.SEXO_INDEFINIDO, p.getSexo());
	}

}
