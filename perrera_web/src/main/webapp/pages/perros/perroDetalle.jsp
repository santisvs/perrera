
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="com.ipartek.formacion.santisvs.perrera.pojo.Perro"%>
<%@include file="../../includes/head.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<%
				//recoger "atributo persona de la request
				Perro per = (Perro) request.getAttribute("perro");
				boolean isNew = (per.getId() == -1);
			%>
			<h1 class="page-header"><%=per.getNombre()%></h1>
		</div>

		<!-- Formularios -->
		<form method="post" action="<%=Constantes.CONTROLLER_PERROS%>">

			<div class="form-group">
				<label for="id" >ID</label>
				<p for="id"><%=per.getId()%></p>
			</div>
			
			<div class="form-group">
				<label for="nombre">Nombre</label>
				<input class="form-control" type="text" name="nombre" placeholder="Escribe tu nombre"
						value="<%=per.getNombre()%>" required
						autofocus>
				<p class="help-block">Example block-level help text here.</p>
			</div>
			
			

			<div class="form-group" id="dnidiv">
				<label for="raza">Raza</label>
				<input class="form-control" id="raza" type="text" name="raza" placeholder="Escribe la raza"
						value="<%=per.getRaza()%>"  required >
				<p class="help-block" id="msgerrorraza"></p>
			</div>
			
						
			
			
			<div class="form-group">
				<label for="sexo">Sexo</label>
					<input class="form-control" type="text" name="sexo" placeholder="Escribe el sexo"
						value="<%=per.getSexo()%>" required >
				<p class="help-block">Example block-level help text here.</p>
			</div>

									
			<input type="hidden" name="id" value="<%=per.getId()%>"> <input
				type="hidden" name="nombre" value="<%=per.getNombre()%>"> <input
				type="hidden" name="raza" value="<%=per.getRaza()%>"> <input
				type="hidden" name="sexo" value="<%=per.getSexo()%>"> 
				<input
				type="hidden" name="op"
				value="<%=Constantes.OP_MODIFICAR%>">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<%
						if (isNew) {
					%>
					<button id="boton_crear" type="submit" class="btn btn-primary"
						style="margin: 10px 0;">Crear</button>
					<%
						} else {
					%>
					<button type="submit" class="btn btn-primary"
						style="margin: 10px 0;">Modificar</button>
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#eliminar">Eliminar</button>
					<%
						}
					%>
				</div>
			</div>
		</form>
		<!-- Pop Up de eliminación-->
		<div class="modal fade" id="eliminar" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Cerrar</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Eliminación de
							perro</h4>
					</div>
					<div id="nuevaAventura" class="modal-body">
						<form method="post" action="<%=Constantes.CONTROLLER_PERROS%>">
							<div class="form-group">
								<input type="hidden" name="op"
									value="<%=Constantes.OP_ELIMINAR%>"> <input
									type="hidden" name="id" value="<%=per.getId()%>"> <label
									for="aviso">¿Está seguro que desea eliminar al perro?
									Esta acción no se puede deshacer.</label>
								<button type="submit" class="btn btn-danger" id="eliminacion"
									style="margin: 10px 0;">Eliminar</button>
								<button type="button" class="btn btn-success"
									data-dismiss="modal" style="margin: 10px 0;">Cerrar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- fin Pop Up de eliminación-->
	</div>
	<!-- END <div class="row"> -->
</div>
<!-- END <div id="page-wrapper"> -->

<%@include file="../../includes/footer.jsp"%>

