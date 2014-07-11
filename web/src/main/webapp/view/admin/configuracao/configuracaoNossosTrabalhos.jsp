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
<script>
	function acaoExclusao(idEntidade) {
		$('#trabalhoRealizado'+idEntidade).remove();
	};
</script>
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
		modelAttribute="configuracaoNossosTrabalhos">
		<ul id="messages"></ul>
		<form:input path="id" type="hidden"  />
		<div>
			<div class="col-md-13">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Configurações Páginas Nossos
							Trabalhos</h3>
					</div>
					<div class="panel-body">
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="tituloPagina">
								<c:out value='Titulo Página:' />
								<span><h6>Define o titulo da página "Nossos
										Trabalhos"</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="tituloPagina" />
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="subTituloPagina">
								<c:out value='Subtitulo da Página:' />
								<span><h6>Define o subtitulo da página "Nossos
										Trabalhos"</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="subTituloPagina" />
							</div>
						</div>
						<div class="linha">
							<div id="tabelaTrabalhos">
								<div class="panel panel-default">
									<div class="panel-heading">Trabalhos Realizados</div>
										
									<div class="panel-body">


										<table class="table">
											<thead>
												<tr>
													<th>Nome Cliente</th>
													<th>Imagem</th>
													<th>Ações</th>
												</tr>
											</thead> 
											<tbody>
												<c:forEach
													items="${configuracaoNossosTrabalhos.trabalhosRealizados}"
													var="trabalhoRealizado">
													<tr id="trabalhoRealizado${trabalhoRealizado.id}">
														<td>${trabalhoRealizado.nomeCliente}
														<td><img src='<c:url value="/resources/${trabalhoRealizado.imagemTrabalho.endereco}"/>'
															class="img-rounded" width="150px" />
														<td><jsp:include page="../includes/iconDelete.jsp">
																<jsp:param value="${trabalhoRealizado.id}"
																	name="idEntidade" />
																<jsp:param
																	value="${pageContext.request.contextPath}/admin/trabalhoRealizado/excluir"
																	name="ajaxUrl" />
															</jsp:include>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<button type="button" class="btn btn-primary"
								onclick="$('#basicModal').modal('show');">Incluir Novo
								Trabalho</button>
									</div>
								</div>
							</div>
							
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="tituloRodape">
								<c:out value='Título Rodapé:' />
								<span><h6>Define o titulo do rodapé da página
										"Nossos Trabalhos"</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="tituloRodape" />
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="subTituloRodape">
								<c:out value='SubTítulo Rodapé:' />
								<span><h6>Define o subtítulo do rodapé da página
										"Nossos Trabalhos"</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="subTituloRodape" />
							</div>
						</div>



						<br>
					</div>
				</div>
			</div>
		</div>

		<p>
			<button type="button"
				onclick="salvarConfiguracaoAJax(document.getElementById('formConfiguracao'),'${pageContext.request.contextPath}/admin/configuracao/nossosTrabalhos',this);"
				class="btn btn-primary">Concluir Alteração</button>
		</p>
	</form:form>

</div>

<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
	aria-labelledby="basicModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Novo Trabalho
					Realizado</h4>
			</div>
			<div class="modal-body">
				<form:form id="formTrabalhoRealizado"
					modelAttribute="trabalhoRealizado">
					<div class="input-group">
						<span class="input-group-addon">Nome Cliente</span> <input
							type="text" class="form-control"
							placeholder="Digite o nome do cliente" name="nomeCliente">
					</div>
					<div class="input-group">
						<jsp:include page="../includes/inputImage.jsp">
							<jsp:param value="imagemTrabalho.endereco" name="path" />
							<jsp:param value="Imagem" name="label" />
						</jsp:include>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Descrição 1</span> <textarea rows="4"
							 class="form-control"
							placeholder="Digite a descrição do trabalho."
							name="descricaoTrabalho1"></textarea>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Descrição 2</span> <textarea rows="4"
							 class="form-control"
							placeholder="Digite a descrição do trabalho."
							name="descricaoTrabalho2"></textarea>
					</div>
					<div class="input-group">
						<span class="input-group-addon">Característica 1</span> <input
							type="text" class="form-control"
							placeholder="Digite uma característica do trabalho"
							name="caracteristica1">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Característica 2</span> <input
							type="text" class="form-control"
							placeholder="Digite uma característica do trabalho"
							name="caracteristica2">
					</div>
					<div class="input-group">
						<span class="input-group-addon">Característica 3</span> <input
							type="text" class="form-control"
							placeholder="Digite uma característica do trabalho"
							name="caracteristica3">
					</div>
				</form:form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button type="button" id="butaoIncluirTrabalhoRealizado"
					onclick="incluirNovoTrabalho('${pageContext.request.contextPath}/admin/trabalhoRealizado/incluir','${pageContext.request.contextPath}/admin/configuracao/nossosTrabalhos')"
					class="btn btn-primary">Incluir Trabalho Realizado</button>
			</div>
		</div>
	</div>
</div>
<script
	src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script>
	function incluirNovoTrabalho(ajaxUrl, urlThisPage) {
		$('body').css('cursor','progress');
		$.ajax({
			url : ajaxUrl,
			type : 'POST',
			data : $('#formTrabalhoRealizado,#formConfiguracao').serialize(),
			success : function(mensagem) {
				$('body').css('cursor','auto');
				$('#basicModal').modal('hide');
				bootbox.alert(mensagem, function() {
					$('body').css('cursor','progress');
					$.ajax({
						url : urlThisPage,
						type : 'GET',
						success : function(html) {
							$('#tabelaTrabalhos').html(
									$('#tabelaTrabalhos', $(html)));
							$('body').css('cursor','auto');
							
						}

					});

				});
			}
		});
	}
</script>
</html>