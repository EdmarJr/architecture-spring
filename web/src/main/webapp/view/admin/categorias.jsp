<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
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
				<th>Descrição</th>
				<th>Posição</th>
				<th>Ações</th>

			</tr>
		</thead>
			<tbody>
		<c:forEach var="categoria" items="${categorias}">
				<tr id="tr${categoria.id}">

					<td>${categoria.nome}</td>
					<td>${categoria.descricao}</td>
					<td>${categoria.posicao}</td>
					<td>
						<jsp:include page="includes/iconEdit.jsp">
							<jsp:param
								value="${pageContext.request.contextPath}/admin/categoria/editar?idCategoria=${categoria.id}"
								name="urlRedirect" />
						</jsp:include> 
						
						<jsp:include page="includes/iconDelete.jsp">
							<jsp:param
								value="${pageContext.request.contextPath}/admin/categoria/excluir"
								name="ajaxUrl" />
							<jsp:param value="${categoria.id}" name="idEntidade" />
						</jsp:include>
					</td>

				</tr>

				<c:if test="${not empty categoria.categoriasFilha}">
					<c:forEach items="${categoria.categoriasFilha}"
						var="categoriaFilha">
						<tr id="tr${categoriaFilha.id}">

							<td> -- ${categoriaFilha.nome}</td>
							<td>${categoriaFilha.descricao}</td>
							<td>${categoriaFilha.posicao}</td>
							<td>
								<jsp:include page="includes/iconEdit.jsp">
									<jsp:param
										value="${pageContext.request.contextPath}/admin/categoria/editar?idCategoria=${categoriaFilha.id}"
										name="urlRedirect" />
								</jsp:include> 
								
								<jsp:include page="includes/iconDelete.jsp">
									<jsp:param
										value="${pageContext.request.contextPath}/admin/categoria/excluir"
										name="ajaxUrl" />
									<jsp:param value="${categoriaFilha.id}" name="idEntidade" />
								</jsp:include>
							</td>

						</tr>
					</c:forEach>
				</c:if>
		</c:forEach>
			</tbody>

	</table>
	<p>
		<jsp:include page="includes/buttonConfirm.jsp">
			<jsp:param value="Incluir Categoria" name="label"/>
			<jsp:param value="${pageContext.request.contextPath}/admin/categoria/incluir" name="urlRedirect"/>
		</jsp:include>
	</p>


</c:if>
</html>