<%@page import="com.ipartek.formacion.santisvs.perrera.Constantes"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ipartek.formacion.santisvs.perrera.pojo.Perro"%>

<%@page import="java.util.Calendar"%>

<!-- /.panel-heading -->
<div class="panel-body">
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive " >
				<table
					class="datatable table table-bordered table-hover table-striped display responsive no-wrap " width="100%">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Raza</th>
							<th>Sexo</th>							
						</tr>
					</thead>
					<tbody>
						<%
							//recoger "atributo listado personas de la request
							ArrayList<Perro> lista = (ArrayList<Perro>) request.getAttribute("listaPerros");
							if (lista == null)
								lista = new ArrayList<Perro>();

							for (int i = 1; i <= lista.size(); i++) {
								Perro per = lista.get(i - 1);
						%>
						<tr>
							<td><a
								href="<%=Constantes.CONTROLLER_PERROS%>?op=<%=Constantes.OP_DETALLE%>&id=<%=per.getId()%>"
								title="Ir al detalle de <%=per.getNombre()%>"><%=per.getNombre()%></a></td>
							<td><%=per.getRaza()%></td>
							<td><%=per.getSexo()%></td>
							
						</tr>
						<%
							} //end for
						%>
					</tbody>
				</table>
			</div>
			<!-- /.table-responsive -->
		</div>
		<!-- /.col-lg-4 (nested) -->
		<div class="col-lg-8">
			<div id="morris-bar-chart"></div>
		</div>
		<!-- /.col-lg-8 (nested) -->
	</div>
	<!-- /.row -->
</div>
<!-- /.panel-body -->