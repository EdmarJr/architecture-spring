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
					<th>Nome</th>
					<th>Categoria</th>
					<th>Código Identificação</th>
					<th>Descrição</th>
					<th>Ações</th>
				</tr>
			</thead>
		<c:forEach var="produto" items="${produtos}">
			<tbody>
				<tr>

					<td>${produto.nome}</td>
					<td>${produto.categoria.nome}</td>
					<td>${produto.codigoIdentificacao}</td>
					<td>${produto.descricao}</td>
					<td><a href='produto/editar?idProduto=${produto.id}'><span class="glyphicon glyphicon-pencil"></span></a>
						<span class="glyphicon glyphicon-pencil"></span>
						<span class="glyphicon glyphicon-pencil"></span></td>

				</tr>
			</tbody>
		</c:forEach>

	</table>
	<a href="produto/incluir">
		<button class="btn btn-default">Incluir Produto</button>
	</a>


</c:if>
</html>