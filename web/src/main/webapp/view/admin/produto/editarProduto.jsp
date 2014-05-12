<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	$(document).ready(function() {

		$('a.delete').on('click', function(e) {
			e.preventDefault();
			imageID = $(this).closest('.image')[0].id;
			alert('Now deleting "' + imageID + '"');
			$(this).closest('.image').fadeTo(300, 0, function() {
				$(this).animate({
					width : 0
				}, 200, function() {
					$(this).remove();
				});
			});
		});

	});
</script>
<style type="text/css">
.containerCadaImagem {
	display: inline-block;
}

.containerBotoesEdicaoImagens {
	display: none;
}
</style>
<div id="formsContent">
	<form:form id="form" modelAttribute="produto" role="form" method="post">

		<c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>
		</c:if>
		<s:bind path="*">
			<c:if test="${status.error}">
				<div id="message" class="error">Form has errors</div>
			</c:if>
		</s:bind>

		<fieldset>
			<legend>Dados Produto</legend>
			<div class="form-group warning">
				<form:label cssClass="col-lg-2 control-label" path="nome">
		  				Nome <form:errors path="nome" />
				</form:label>
				<div class="col-lg-6">
					<form:input path="nome" cssClass="form-control" />
				</div>
			</div>
			<br>
			<div class="form-group">
				<form:label class="col-lg-2 control-label" path="categoria">
						Categoria
					</form:label>
				<div class="col-lg-6">
					<form:select class="form-control" path="categoria">
						<form:options items="${categorias}" itemLabel="nome" />
					</form:select>
				</div>
			</div>
			<br>
			<div class="form-group warning">
				<form:label cssClass="col-lg-2 control-label"
					path="codigoIdentificação">
		  				Cod. Identificação <form:errors path="codigoIdentificação" />
				</form:label>
				<div class="col-lg-6">
					<form:input path="codigoIdentificação" cssClass="form-control" />
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

		<fieldset>
			<legend> Imagens Vinculadas </legend>


			<div id="container">
				<c:forEach var="imagem" items="${produto.imagens}">
					<div class='containerCadaImagem'
						onmouseover="document.getElementById('botoes${imagem.id}').style.display = 'initial'"
						onmouseout="document.getElementById('botoes${imagem.id}').style.display = 'none'">
						<img
							src='<c:url value="/resources/images/${imagem.enderecoMiniatura}"/>'
							class="img-thumbnail">
						<div id="botoes${imagem.id}" class="containerBotoesEdicaoImagens">
							<button class="btn btn-primary">Principal</button>
							<button class="btn btn-danger">Excluir</button>
						</div>
						<input type="hidden" id="inputhidden:${imagem.id}"
							value="${imagem.ativo}">
					</div>
				</c:forEach>
			</div>
		</fieldset>
		
		<p><button type="submit" class="btn btn-primary">Submit</button></p>	
	</form:form>
	
	<script type="text/javascript">
			$(document).ready(function() {
			$("#form").submit(function() {  
				$.post($(this).attr("action"), $(this).serialize(), function(html) {
					$("#formsContent").replaceWith(html);
					$('html, body').animate({ scrollTop: $("#message").offset().top }, 500);
				});
				return false;  
				});			
			});
		</script>
</div>
</html>