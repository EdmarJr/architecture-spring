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
					<th>C�digo Identifica��o</th>
					<th>Descri��o</th>
					<th>A��es</th>
				</tr>
			</thead>
			<tbody>
		<c:forEach var="produto" items="${produtos}">
				<tr>

					<td>${produto.nome}</td>
					<td>${produto.categoria.nome}</td>
					<td>${produto.codigoIdentificacao}</td>
					<td>${produto.descricao}</td>
					<td><a href='${pageContext.request.contextPath}/admin/produto/editar?idProduto=${produto.id}'><span class="linkEditar"></span></a>
						<span class="glyphicon glyphicon-pencil"></span>
						<span class="glyphicon glyphicon-pencil"></span></td>

				</tr>
		</c:forEach>
			</tbody>

	</table>
	<a href="${pageContext.request.contextPath}/admin/produto/incluir">
		<button class="btn btn-default">Incluir Produto</button>
	</a>


</c:if>
</html>