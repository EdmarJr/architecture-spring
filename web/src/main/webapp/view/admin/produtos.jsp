<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function acaoExclusao(idEntidade) {
		var element = document.getElementById("tr" + idEntidade);
		var parentNode = element.parentNode;
		parentNode.removeChild(element);
	}
</script>
<c:if test="${pageContext.request.userPrincipal.name != null}">

	<table class='table table-striped table-bordered table-condensed'>
		<thead>
			<tr>
				<th>Nome</th>
				<th>Categoria</th>
				<th>Posição</th>
				<th>Código Identificação</th>
				<th>Descrição</th>
				<th>Ações</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="produto" items="${produtos}">
				<tr id="tr${produto.id}">
					<td>${produto.nome}</td>
					<td>${produto.categoria.nome}</td>
					<td>${produto.posicao}</td>
					<td>${produto.codigoIdentificacao}</td>
					<td>${produto.descricao}</td>
					<td>
							<jsp:include page="includes/iconEdit.jsp">
								<jsp:param
									value="${pageContext.request.contextPath}/admin/produto/editar?idProduto=${produto.id}"
									name="urlRedirect" />
							</jsp:include> 
							
								
						 <jsp:include
								page="includes/iconDelete.jsp">
							<jsp:param
								value="${pageContext.request.contextPath}/admin/produto/excluir"
								name="ajaxUrl" />
							<jsp:param value="${produto.id}" name="idEntidade" />
						</jsp:include></td>

				</tr>
			</c:forEach>
		</tbody>

	</table>
	<p> 
		<jsp:include page="includes/buttonConfirm.jsp">
			<jsp:param value="Incluir Produto" name="label"/>
			<jsp:param value="${pageContext.request.contextPath}/admin/produto/incluir" name="urlRedirect"/>
		</jsp:include>
	</p>


</c:if>
</html>