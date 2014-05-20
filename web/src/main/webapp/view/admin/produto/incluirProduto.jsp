<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src='<c:url value="/resources/admin/js/utils/validation.js"/>'></script>
<script src='<c:url value="/resources/admin/js/aplicacao/produto/crudProduto.js"/>'></script>
<div id="formsContent">
	<form:form method="POST" id="formProduto" modelAttribute="produto" onsubmit="return validarRequiredByName(['nome','categoria'])">
		<ul id="messages"></ul>
		<fieldset>
			<legend>Dados Produto</legend>
			<jsp:include page="../includes/inputText.jsp">
				<jsp:param value="nome" name="path" />
				<jsp:param value="Nome" name="label" />
			</jsp:include>
			<br>
			<jsp:include page="../includes/selectCategoria.jsp"></jsp:include>
			<br>
			<jsp:include page="../includes/inputText.jsp">
				<jsp:param value="codigoIdentificacao" name="path" />
				<jsp:param value="Cod. Identificação" name="label" />
			</jsp:include>
			<br>
			<jsp:include page="../includes/inputText.jsp" >
				<jsp:param value="posicao" name="path"/>
				<jsp:param value="Posição" name="label"/>
				<jsp:param value="posicao_id_mask" name="id"/>
			</jsp:include>
			<br>
			<jsp:include page="../includes/inputTextArea.jsp">
				<jsp:param value="descricao" name="path" />
				<jsp:param value="Descrição" name="label" />
			</jsp:include>
			<br>

		</fieldset>
		<br>

		<button type="submit" class="btn btn-primary">Incluir</button>
		<button type="button"
			onclick="gerenciarImagensComValidacao('${pageContext.request.contextPath}/admin/produto/incluirAjax', '${pageContext.request.contextPath}', ['nome','categoria'])"
			class="btn btn-primary">Gerenciar Imagens</button>
	</form:form>

</div>
<script type="text/javascript" src='<c:url value="/resources/admin/js/jquery.mask.min.js"/>'></script>
<script type="text/javascript">
	$('#posicao_id_mask').mask('9999');
</script>
</html>