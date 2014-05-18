<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
.containerCadaImagem {
	display: inline-block;
}

.containerBotoesEdicaoImagens {
	display: none;
}
</style>
<script>
	function validarRequiredByName(names) {
		var submeter = true;
		for(var i = 0; i<names.length; i++) {
			nome = names[i];
			var elements = document.getElementsByName(nome);
			for(var j = 0; j<elements.length; j++) {
				element = elements[j];
				if(element.value == "") {
					submeter = false;
				}
			}
		}
		if(submeter) {
			return true;
		}
		return false;
	}
</script>
<div id="formsContent">
	<form:form method="POST" modelAttribute="produto" onsubmit="validarRequiredByName({'nome','codigoIdentificacao'})">
	
		<fieldset>
			<legend>Dados Produto</legend>
			<ul id="messages">
			
			</ul>
			<div class="form-group warning">
				<form:label  cssClass="col-lg-2 control-label" path="nome">
		  				Nome <form:errors path="nome" />
				</form:label>
				<div class="col-lg-6">
					<form:input path="nome"  cssClass="form-control" />
				</div>
			</div>
			<br>
			<jsp:include page="../includes/selectCategoria.jsp" ></jsp:include>
			<br>
			<div class="form-group warning">
				<form:label cssClass="col-lg-2 control-label"
					path="codigoIdentificacao">
		  				Cod. Identificação <form:errors path="codigoIdentificacao" />
				</form:label>
				<div class="col-lg-6">
					<form:input path="codigoIdentificacao" cssClass="form-control" />
				</div>
			</div>
			<br>
			<div class="form-group">
				<form:label class="col-lg-2 control-label" path="descricao"> 
		  				Descrição
					</form:label>
				<div class="col-lg-6">
					<form:textarea class="form-control" path="descricao" />
				</div>
			</div>

		</fieldset>

		
		<button type="submit" class="btn btn-primary">Incluir</button>
		<button type="submit" class="btn btn-primary">Gerenciar Imagens</button>
		
	</form:form>
	
</div>
</html>