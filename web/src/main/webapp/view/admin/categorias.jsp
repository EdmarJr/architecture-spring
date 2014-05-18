<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
<c:if test="${pageContext.request.userPrincipal.name != null}">

	<table class='table table-striped table-bordered table-condensed'>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Ações</th>

			</tr>
		</thead>
			<tbody>
		<c:forEach var="categoria" items="${categorias}">
				<tr>

					<td>${categoria.nome}</td>
					<td>${categoria.descricao}</td>
					<td><a
						href='${pageContext.request.contextPath}/admin/categoria/editar?idCategoria=${categoria.id}'><span
							class="glyphicon glyphicon-pencil"></span></a> <span
						class="glyphicon glyphicon-pencil"></span> <span
						class="glyphicon glyphicon-pencil"></span></td>

				</tr>

				<c:if test="${not empty categoria.categoriasFilha}">
					<c:forEach items="${categoria.categoriasFilha}"
						var="categoriaFilha">
						<tr>

							<td> -- ${categoriaFilha.nome}</td>
							<td>${categoriaFilha.descricao}</td>
							<td><a
								href='${pageContext.request.contextPath}/admin/categoria/editar?idCategoria=${categoriaFilha.id}'><span
									class="glyphicon glyphicon-pencil"></span></a> <span
								class="glyphicon glyphicon-pencil"></span> <span
								class="glyphicon glyphicon-pencil"></span></td>

						</tr>
					</c:forEach>
				</c:if>
		</c:forEach>
			</tbody>

	</table>
	<a href="${pageContext.request.contextPath}/admin/categoria/incluir">
		<button class="btn btn-default">Incluir Categoria</button>
	</a>


</c:if>
</html>