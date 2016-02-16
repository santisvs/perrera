<%@ page contentType="text/html; charset=UTF-8"%>

<%@include file="/includes/head.jsp"%>

<div id="page-wrapper">
	
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">Perros</h1>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-user fa-fw"></i> Últimos 500 perros inscritos.
				<div class="pull-right">
					<div class="btn-group">
						<button type="button" class="btn btn-default btn-xs">
							<a href="<%=Constantes.CONTROLLER_PERROS%>?op=<%=Constantes.OP_NUEVO%>"
								title="Crear registro"> <i class="fa fa-plus fa-fw"></i>
								Añadir Perro
							</a>
						</button>
					</div>
				</div>
			</div>
			<%@include file="/includes/listaPerros.jsp"%>

		</div>
	</div>
</div>
<!-- /#page-wrapper -->

<%@include file="/includes/footer.jsp"%>
