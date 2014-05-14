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
					<td><a href='${pageContext.request.contextPath}/admin/orcamento/processar?idOrcamento=${orcamento.id}'><span class="glyphicon glyphicon-pencil"></span></a></td>

				</tr>
			</tbody>
		</c:forEach>

	</table>


</c:if>
</html>