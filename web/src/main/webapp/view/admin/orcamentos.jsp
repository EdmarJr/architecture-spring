<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src='<c:url value="/resources/admin/js/aplicacao/table.js"/>'></script>
<script>
	function onClickTable() {
				    $.ajax({url: '${pageContext.request.contextPath}/admin/orcamento/detalhar',
				        data: { 'idOrcamento' : document.getElementsByClassName('active')[0].id},
				        type: "POST",
				        success: function(html) {
				        	$('#conteudoDetalhar').empty();
// 				        	var element = html.getElementById('conteudoDetalhar');
				        	$('#conteudoDetalhar').replaceWith(html);
				        }
				    });
				      
				    event.preventDefault();
	}
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
				<tr id="${orcamento.id}" onclick="selecionarRow(this,onClickTable)">

					<td>${orcamento.cliente.nome}</td>
					<td>${orcamento.id}</td>
					<td><c:if test="${orcamento.emAberto}">
							Em Aberto
						</c:if> <c:if test="${!orcamento.emAberto}">
							Fechado
						</c:if></td>
					<td>${orcamento.horaRegistro}</td>

				</tr>
			</tbody>
		</c:forEach>

	</table>
	<div id="conteudoDetalhar" style="margin: 0 auto;">
		<div class="col-md-5">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Informações Orçamento</h3>
				</div>
				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Ticket:</span>
								<span style="float: right">${orcamentoSelecionado.id}</span>
						</span></li>
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Em
									Aberto:</span> <span style="float: right">${orcamentoSelecionado.emAberto}</span>
						</span></li>
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Data
									Registro:</span> <span style="float: right">${orcamentoSelecionado.horaRegistro}</span>
						</span></li>
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Data
									Última Atualização:</span> <span style="float: right">${orcamentoSelecionado.ultimaAtualizacao}</span>
						</span></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-4">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Informações Cliente</h3>
				</div>
				<div class="panel-body">
					<ul class="list-group">
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Nome:</span> <span
								style="float: right">${orcamentoSelecionado.cliente.nome}</span>
						</span></li>
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Telefone:</span>
								<span style="float: right">${orcamentoSelecionado.cliente.telefone}</span>
						</span></li>
						<li class="list-group-item"><span> <span
								class="label label-default" style="text-size: 10">Email:</span>
								<span style="float: right">${orcamentoSelecionado.cliente.email}</span>
						</span></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="col-md-3">
			<div class="list-group">
				<a href="#" class="list-group-item list-group-item-success">Dapibus
					ac facilisis in</a> <a href="#"
					class="list-group-item list-group-item-info">Cras sit amet nibh
					libero</a> <a href="#" class="list-group-item list-group-item-warning">Porta
					ac consectetur ac</a> <a href="#"
					class="list-group-item list-group-item-danger">Vestibulum at
					eros</a>
			</div>
		</div>

		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Produtos Orçamento</h3>
				</div>
				<div class="panel-body">
					<table class='table table-striped table-bordered table-condensed'>
						<thead>
							<tr>
								<th>Nome</th>
								<th>Codigo Identificação</th>
								<th>Quantidade</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach items="${orcamentoSelecionado.produtosOrcamento}"
								var="produtos">
								<tr>
									<td>${produtos.produto.nome}</td>
									<td>${produtos.produto.codigoIdentificacao}</td>
									<td>${produtos.quantidadeProdutos}</td>
								<tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>



</c:if>
</html>