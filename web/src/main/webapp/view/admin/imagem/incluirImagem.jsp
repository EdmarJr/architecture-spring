<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="pt-br" xml:lang="pt-br">
<div id="formsContent">
	<form:form method="POST" modelAttribute="imagem" action="${pageContext.request.contextPath}/admin/imagem/incluir">
	
		<fieldset>
			<legend>Dados Imagem</legend>
			<form:input path="idEntidade" type="hidden" />
			<form:input path="tipoEntidade" type="hidden" />
			<jsp:include page="../includes/inputText.jsp" >
				<jsp:param value="nome" name="path"/>
				<jsp:param value="Nome" name="label"/>
			</jsp:include>
			<br>
			<jsp:include page="../includes/inputText.jsp" >
				<jsp:param value="descricao" name="path"/>
				<jsp:param value="Descrição" name="label"/>
			</jsp:include>
			<br>
			<jsp:include page="../includes/inputText.jsp" >
				<jsp:param value="posicao" name="path"/>
				<jsp:param value="Posição" name="label"/>
				<jsp:param value="posicao_id_mask" name="id"/>
			</jsp:include>
			<br>
			<jsp:include page="../includes/inputImage.jsp" >
				<jsp:param value="endereco" name="path"/>
				<jsp:param value="Imagem Ampliada" name="label"/>
			</jsp:include>
			<jsp:include page="../includes/inputImage.jsp" >
				<jsp:param value="enderecoMiniatura" name="path"/>
				<jsp:param value="Imagem Miniatura" name="label"/>
			</jsp:include>
			<br>
			<br>
		</fieldset>
		
		
		<p><button type="submit" class="btn btn-primary">Incluir</button></p>	
	</form:form>
	
</div>
<script type="text/javascript" src='<c:url value="/resources/admin/js/jquery.mask.min.js"/>'></script>
<script type="text/javascript">
	$('#posicao_id_mask').mask('9999');
</script>

</html>