package com.ipartek.formacion.santisvs.perrera.pojo;

/**
 * <b>POJO Perro</b><br>
 *
 * Clase básica Perro con atributos:<br>
 *
 * <ul>
 * <li>{@code id} corresponde al identificador de la base de datos</li>
 * <li>{@code nombre} corresponde al nombre de pila del perro</li>
 * <li>{@code raza} corresponde a la raza del perro</li>
 * <li>{@code sexo} corresponde al sexo del perro</li>
 * </ul>
 *
 * <b>Clase compuesta de:</b><br>
 * <ol>
 * <li>Constantes</li>
 * <li>Atributos</li>
 * <li>Constructores</li>
 * <li>Getters y Setters</li>
 * <li>toString</li>
 * </ol>
 *
 * @author Santisvs
 *
 */

public class Perro {

	/********************
	 * CONSTANTES
	 ********************/
	public static final String NOMBRE_SIN_DEFINIR = "Sin Definir";

	public static final String RAZA_SIN_DEFINIR = "Sin Definir";

	public static final char SEXO_MACHO = 'M';
	public static final char SEXO_HEMBRA = 'H';
	public static final char SEXO_INDEFINIDO = 'I';

	/********************
	 * ATRIBUTOS
	 ********************/
	private int id;
	private String nombre;
	private String raza;
	private char sexo; // 'H': hombre, 'M':Mujer, 'I': Indefinido

	/********************
	 * CONSTRUCTORES
	 ********************/
	public Perro() {
		super();
		this.id = -1;
		this.nombre = NOMBRE_SIN_DEFINIR;
		this.raza = RAZA_SIN_DEFINIR;
		this.sexo = SEXO_INDEFINIDO;
	}

	public Perro(String nombre, String raza, char sexo) {
		super();
		setNombre(nombre);
		setRaza(raza);
		setSexo(sexo);
	}

	public Perro(String nombre, String raza, String sexo) {
		super();
		setNombre(nombre);
		setRaza(raza);
		setSexo(sexo);
	}

	/********************
	 * GETTERS Y SETTERS
	 ********************/
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		if ((nombre == null) || (nombre == "")) {
			this.nombre = NOMBRE_SIN_DEFINIR;
		} else {
			this.nombre = nombre;
		}
	}

	/**
	 * @return the raza
	 */
	public String getRaza() {
		return raza;
	}

	/**
	 * @param raza
	 *            the raza to set
	 */
	public void setRaza(String raza) {
		if ((raza == null) || (raza == "")) {
			this.raza = RAZA_SIN_DEFINIR;
		} else {
			this.raza = raza;
		}
	}

	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}

	/**
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(char sexo) {
		if (sexo == ' ') {
			this.sexo = SEXO_INDEFINIDO;
		} else {
			this.sexo = sexo;
		}
	}

	/**
	 * Sobrecarga de funcion setSexo Cubrimos la posibilidad de una entrada por
	 * String o NULL
	 *
	 * Comparamos la primera letra del String
	 *
	 * <ul>
	 * <li>'H' Hembra</li>
	 * <li>'M' Macho</li>
	 * </ul>
	 *
	 * @param sexo
	 *            the sexo to set
	 */
	public void setSexo(String sexo) {
		if (sexo == null) {
			this.sexo = SEXO_INDEFINIDO;
		} else {
			switch (sexo.charAt(0)) {
			case SEXO_HEMBRA:
				this.sexo = SEXO_HEMBRA;
				break;

			case 'h':
				this.sexo = SEXO_HEMBRA;
				break;

			case SEXO_MACHO:
				this.sexo = SEXO_MACHO;
				break;

			case 'm':
				this.sexo = SEXO_MACHO;
				break;

			default:
				this.sexo = SEXO_INDEFINIDO;
				break;
			}
		}
	}

	/********************
	 * TO STRING
	 ********************/
	@Override
	public String toString() {
		return "perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza
				+ ", sexo=" + sexo + "]";
	}

}
