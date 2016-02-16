package com.ipartek.formacion.santisvs.perrera.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.santisvs.perrera.Constantes;
import com.ipartek.formacion.santisvs.perrera.pojo.Perro;
import com.ipartek.formacion.santisvs.perrera.service.PerroService;
import com.ipartek.formacion.santisvs.perrera.service.impl.PerroServiceImpl;

/**
 * Servlet implementation class PerroServlet
 */
public class PerroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected static RequestDispatcher dispatch;
	private static PerroService servicioPerro;
	private static int operacion;
	private static String pId;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		servicioPerro = PerroServiceImpl.getSingleton();
	}

	@Override
	public void destroy() {
		super.destroy();
		servicioPerro = null;
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			// recoger parámetros a realizar
			if (request.getParameter("op") != null) {
				operacion = Integer.parseInt(request.getParameter("op"));
			} else {
				operacion = Constantes.OP_LISTAR;
			}

			// Realizar accion
			switch (operacion) {
			case Constantes.OP_LISTAR:
				listar(request);
				break;
			case Constantes.OP_DETALLE:
				detalle(request);
				break;
			case Constantes.OP_NUEVO:
				nuevo(request);
				break;
			case Constantes.OP_ELIMINAR:
				eliminar(request);
				break;
			case Constantes.OP_MODIFICAR:
				modificarCrear(request);
				break;
			}
			/*
			 * forward para servir la jsp (lanzarlo). en forward hay que poner
			 * dos argumentos. doGet tiene dos request y response, al ser una
			 * petición interna, hay que poner los mismos
			 */
			dispatch.forward(request, response);
		} catch (Exception e) {
			// TODO mejor en un LOG
			e.printStackTrace();

			// TODO ir a página error 404.jsp o 500.jsp
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void listar(HttpServletRequest request) {
		// Guardar listado como atributo en request
		request.setAttribute("listaPerros", servicioPerro.listar());

		// Petición interna a la jsp (RequestDistapecher es para decirle a donde
		// tiene que ir, se carga el dispatcher)
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERRO_LIST);

	}

	private void modificarCrear(HttpServletRequest request) {
		// recoger parámetros formulario
		int id = Integer.parseInt(request.getParameter("id"));
		String pNombre = request.getParameter("nombre"), pRaza = request
				.getParameter("raza"), pSexo = request.getParameter("sexo");

		// construir persona
		Perro per = new Perro();
		per.setId(id);
		per.setNombre(pNombre);
		per.setRaza(pRaza);
		per.setSexo(pSexo);

		// persistir en la bbdd
		if (servicioPerro.existe(per.getId())) {
			servicioPerro.modificar(per);
		} else {
			servicioPerro.insertar(per);
		}
		// listar
		listar(request);

	}

	private void eliminar(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		Perro p = servicioPerro.detalle(id);
		servicioPerro.eliminar(p);

		listar(request);

	}

	private void nuevo(HttpServletRequest request) {
		Perro p = new Perro();
		request.setAttribute("perro", p);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERRO_FORM);

	}

	private void detalle(HttpServletRequest request) {
		pId = request.getParameter("id");
		request.setAttribute("perro",
				servicioPerro.detalle(Integer.parseInt(pId)));
		dispatch = request.getRequestDispatcher(Constantes.VIEW_PERRO_FORM);

	}

}
