<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function selecionarOrcamento(e) {
		mudarBackGround(e.target, "gray");
		};

	function mudarBackGround(element, cor) {
			
		};

</script>
<c:if test="${pageContext.request.userPrincipal.name != null}">



	<table class='table table-striped table-bordered table-condensed'>
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Ticket</th>
				<th>Status</th>
				<th>Data Registro</th>
			</tr>
		</thead>
		<c:forEach var="orcamento" items="${orcamentos}">
			<tbody>
				<tr>

					<td>${orcamento.cliente.nome}</td>
					<td>${orcamento.id}</td>
					<td>
						<c:if test="${orcamento.emAberto}">
							Em Aberto
						</c:if>
						<c:if test="${!orcamento.emAberto}">
							Fechado
						</c:if>
					</td>
					<td>${orcamento.horaRegistro}</td>

				</tr>
			</tbody>
		</c:forEach>

	</table>
	<div style="margin:0 auto;">
<div class="col-md-5">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informa��es Or�amento</h3>
			</div>
			<div class="panel-body">
				<ul class="list-group">
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Ticket:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Em Aberto:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Data Registro:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Data �ltima Atualiza��o:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-md-4">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Informa��es Cliente</h3>
			</div>
			<div class="panel-body" >
				<ul class="list-group">
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Nome:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Telefone:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
					<li class="list-group-item">
						<span>
							<span class="label label-default" style="text-size : 10">Email:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="list-group">
  <a href="#" class="list-group-item list-group-item-success">Dapibus ac facilisis in</a>
  <a href="#" class="list-group-item list-group-item-info">Cras sit amet nibh libero</a>
  <a href="#" class="list-group-item list-group-item-warning">Porta ac consectetur ac</a>
  <a href="#" class="list-group-item list-group-item-danger">Vestibulum at eros</a>
</div>
	</div>
	
	<div class="col-md-12">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Produtos Or�amento</h3>
			</div>
			<div class="panel-body">
			<table class='table table-striped table-bordered table-condensed'>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Codigo Identifica��o</th>
				<th>Quantidade</th>

			</tr>
		</thead>
			<tbody>
			<tr>
			<td> Teste</td>
			<td> Teste</td>
			<td> Teste</td>
			<tr>
			</tbody>
			</table>
			</div>
		</div>
	</div>
	</div>



</c:if>
</html>