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
		modelAttribute="configuracaoEndereco">
		<ul id="messages"></ul>
		<form:input path="id" type="hidden" />
		<div>
			<div class="col-md-13">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Configurações Páginas Nossos Trabalhos</h3>
					</div>
					<div class="panel-body">
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="tituloJanelaEndereco">
								<c:out value='Titulo Janela:' />
								<span><h6>Define o titulo da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="tituloJanelaEndereco"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="texto1">
								<c:out value='Primeira Frase:' />
								<span><h6>Define a primeira frase da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="texto1"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="texto2">
								<c:out value='Segunda Frase:' />
								<span><h6>Define a segunda frase da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="texto2"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="texto3">
								<c:out value='Terceira Frase:' />
								<span><h6>Define a terceira frase da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="texto3"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="texto4">
								<c:out value='Quarta Frase:' />
								<span><h6>Define a quarta frase da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="texto4"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="texto5">
								<c:out value='Quinta Frase:' />
								<span><h6>Define a quinta frase da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="texto5"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="enderecoGoogleMaps">
								<c:out value='Endereço Google Maps:' />
								<span><h6>Define o endereço que vai ser utilizado para mostrar a representação do mapa na janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="enderecoGoogleMaps"/>
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label"
								path="tituloBotao">
								<c:out value='Titulo do botão de fechar:' />
								<span><h6>Define o nome do botão de fechar da janela de endereço (Janela que se abre quando clica no icone de mensagem no menu).</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="tituloBotao"/>
							</div>
						</div>
						

						<br>
					</div>
				</div>
			</div>
		</div>

		<p>
			<button type="button"
				onclick="salvarConfiguracaoAJax(document.getElementById('formConfiguracao'),'${pageContext.request.contextPath}/admin/configuracao/endereco',this);"
				class="btn btn-primary">Concluir Alteração</button>
		</p>
	</form:form>

</div>
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/jquery.mask.min.js"/>'></script>
</html>