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
<script
	src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script src='<c:url value="/resources/admin/js/utils/validation.js"/>'></script>
<script
	src='<c:url value="/resources/admin/js/aplicacao/configuracao/configuracao.js"/>'></script>
<style>
.linha {
	display: inline-block;
	width: 100%;
}
</style>
<div id="formsContent">
	<form:form method="POST" id="formConfiguracao"
		modelAttribute="configuracaoOrcamento">
		<ul id="messages"></ul>
		<form:input path="id" type="hidden" />
		<div>
			<div class="col-md-13">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Configurações Orçamento</h3>
					</div>
					<div class="panel-body">
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="indicacaoHabilitada">
								<c:out value='Habilitar Indicação: ' />
								<span><h6>Habilita o campo de indicação no
										formulario de solicitação de orçamento do cliente.</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:select class="form-control" path="indicacaoHabilitada">
									<form:option label="Não" value="false" />
									<form:option label="Sim" value="true" />
								</form:select>
							</div>
						</div>
						

						<br>
					</div>
				</div>
			</div>
		</div>

		<p>
			<button type="button"
				onclick="salvarConfiguracaoAJax(document.getElementById('formConfiguracao'),'${pageContext.request.contextPath}/admin/configuracao/orcamento',this);"
				class="btn btn-primary">Concluir Alteração</button>
		</p>
	</form:form>

</div>
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/jquery.mask.min.js"/>'></script>
</html>