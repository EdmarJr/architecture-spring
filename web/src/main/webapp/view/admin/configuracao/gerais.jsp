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
<script src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script src='<c:url value="/resources/admin/js/utils/validation.js"/>'></script>
<script src='<c:url value="/resources/admin/js/aplicacao/configuracao/configuracao.js"/>'></script>
<div id="formsContent">
	<form:form method="POST" id="formConfiguracao" modelAttribute="configuracao">
		<ul id="messages"></ul>
		<form:input path="id" type="hidden" />
		<div>
			<div class="col-md-13">
				<div class="panel panel-primary">
					<div class="panel-heading">	
						<h3 class="panel-title">Configurações Gerais</h3>
					</div>
					<div class="panel-body">
						<jsp:include page="../includes/inputImage.jsp">
							<jsp:param value="logoMenuSuperior.endereco" name="path" />
							<jsp:param value="Logo Menu Superior" name="label" />
						</jsp:include>
						<br>
					</div>
				</div>
			</div>
		</div>

		<p><button type="button"
			onclick="salvarConfiguracaoAJax(document.getElementById('formConfiguracao'),'${pageContext.request.contextPath}/admin/configuracao/gerais',this);"
			class="btn btn-primary">Concluir Alteração</button></p>
	</form:form>

</div>
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/jquery.mask.min.js"/>'></script>
</html>