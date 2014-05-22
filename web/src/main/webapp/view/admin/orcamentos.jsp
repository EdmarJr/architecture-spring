<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test="${pageContext.request.userPrincipal.name != null}">



	<table class='table table-striped table-bordered table-condensed'>
		<thead>
			<tr>
				<th>Cliente</th>
				<th>Produtos</th>
				<th>Ações</th>
			</tr>
		</thead>
		<c:forEach var="orcamento" items="${orcamentos}">
			<tbody>
				<tr>

					<td>${orcamento.cliente.nome}</td>
					<td>teste</td>
					<td><a
						href='${pageContext.request.contextPath}/admin/orcamento/processar?idOrcamento=${orcamento.id}'><span
							class="glyphicon glyphicon-pencil"></span></a></td>

				</tr>
			</tbody>
		</c:forEach>

	</table>
<div class="col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Informações Orçamento</h3>
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
							<span class="label label-default" style="text-size : 10">Data Última Atualização:</span> 
							<span style="float:right">TESTEEEE</span>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<div class="col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">Informações Cliente</h3>
			</div>
			<div class="panel-body">
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
	
	<div class="col-md-8">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Produtos Orçamento</h3>
			</div>
			<div class="panel-body">
				<ul class="list-group">
					<li class="list-group-item"><span class="badge">14</span>
						Canetas2</li>
					<li class="list-group-item"><span class="badge">14</span>
						Canetas1</li>
					<li class="list-group-item"><span class="badge">14</span>
						Canetas3</li>
					<li class="list-group-item"><span class="badge">14</span>
						Canetas4</li>
				</ul>
			</div>
		</div>
	</div>



</c:if>
</html>