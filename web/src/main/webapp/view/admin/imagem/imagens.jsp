<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
<style>
.iconAddImagem:HOVER {
	background-color: green;
	cursor: pointer;
}

</style>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<div>
		<jsp:include page="../includes/galeriaDeImagens.jsp" >
			<jsp:param value="${pageContext.request.contextPath}/admin/imagem/editar?idEntidade=${idEntidade}&tipoEntidade=${tipoEntidade}" name="urlEdit"/>
			<jsp:param value="${pageContext.request.contextPath}/admin/imagem/excluir" name="urlDelete"/>
			<jsp:param value="${idEntidade}/admin/imagem/excluir" name="idEntidade"/>
			<jsp:param value="${tipoEntidade}/admin/imagem/excluir" name="tipoEntidade"/>
		</jsp:include>
	</div>
	
	<img src='<c:url value="/resources/admin/icons/add.png"/>' class="iconAddImagem" style="float:left;"
		onclick="window.location.href = '${pageContext.request.contextPath}/admin/imagem/incluir?idEntidade=${idEntidade}&tipoEntidade=${tipoEntidade}';">
</c:if>
</html>