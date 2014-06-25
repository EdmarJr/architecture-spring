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
		$('#estrofe' + idEntidade).remove();
	};
	function acaoExclusaoImagem(idEntidade) {
		$('#imagem' + idEntidade).remove();
	};


	function excluirImagem(idEntidade,idImagem,tipoEntidade,ajaxUrl) {
		bootbox.confirm("Tem certeza que deseja excluir a o registro de id "+idImagem+" ?", function(result) {
			if(result) {
			
			    $.ajax({url: ajaxUrl,
			        data: { 'idEntidade' : idEntidade,'idImagem':idImagem,'tipoEntidade':tipoEntidade},
			        type: "POST",
			        success: function(idEntidade) {
			        	acaoExclusaoImagem(idEntidade);     
			        }
			    });
			      
			    event.preventDefault();
			  }

		});
		
	}
</script>
<script
	src='<c:url value="/resources/admin/js/aplicacao/configuracao/configuracao.js"/>'></script>
<style>
.linha {
	display: inline-block;
	width: 100%;
}
.iconDeleteAboveImg:HOVER {
	background-color: red;
	cursor: pointer;
}
</style>

<div id="formsContent">
	<form:form method="POST" id="formConfiguracao"
		modelAttribute="configuracaoPaginaInicial">
		<ul id="messages"></ul>
		<form:input path="id" type="hidden" />
		<div>
			<div class="col-md-13">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Configurações Página Inicial</h3>
					</div>
					<div class="panel-body">
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="textoImagem">
								<c:out value='Texto Imagem:' />
								<span><h6>Define o texto que aparece em cima da
										imagem principal</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="textoImagem" />
							</div>
						</div>

						<div class="input-group">
							<jsp:include page="../includes/inputImage.jsp">
								<jsp:param value="imagemPaginaInicial.endereco" name="path" />
								<jsp:param value="Imagem Principal" name="label" />
							</jsp:include>
						</div>
						<div class="linha">
							<div id="tabelaEstrofes">
								<div class="panel panel-default">
									<div class="panel-heading">Estrofes</div>

									<div class="panel-body">


										<table class="table">
											<thead>
												<tr>
													<th>Titulo Estrofe</th>
													<th>Ações</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${configuracaoPaginaInicial.estrofes}"
													var="estrofe">
													<tr id="estrofe${estrofe.id}">
														<td>${estrofe.tituloEstrofe}</td>
														<td><jsp:include page="../includes/iconDelete.jsp">
																<jsp:param value="${estrofe.id}" name="idEntidade" />
																<jsp:param
																	value="${pageContext.request.contextPath}/admin/estrofePaginaInicial/excluir"
																	name="ajaxUrl" />
															</jsp:include>
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<button type="button" class="btn btn-primary"
											onclick="$('#basicModal').modal('show');">Incluir
											Nova Estrofe</button>
									</div>
								</div>
							</div>

						</div>
						<div class="linha">
							<div id="tabelaImagens">
								<div class="panel panel-default">
									<div class="panel-heading">Principais Clientes Imagens</div>

									<div class="panel-body">


										<table class="table">
											<thead>
												<tr>
													<th>Imagens</th>
													<th>Ações</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach
													items="${configuracaoPaginaInicial.imagensPrincipaisClientes}"
													var="imagemTemp">
													<tr id="imagem${imagemTemp.id}">
														<td><img
															src='<c:url value="/resources/${imagemTemp.endereco}"/>'
															class="img-rounded" width="150px" />
														<td><img id="icondeleteimg${imagemTemp.id}"
															class="iconDeleteAboveImg"
															onclick='excluirImagem("${configuracaoPaginaInicial.id}","${imagemTemp.id}","configuracaoPaginaInicial","${pageContext.request.contextPath}/admin/imagem/excluir")'
															src='<c:url value="/resources/admin/icons/delete.png"/>'
															alt="Excluir" width=.. height=.. />
													</tr>
												</c:forEach>
											</tbody>
										</table>
										<button type="button" class="btn btn-primary"
											onclick="$('#modalImagem').modal('show');">Incluir
											Nova Imagem Cliente</button>
									</div>
								</div>
							</div>

						</div>
						
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="tituloTexto1">
								<c:out value='Título Texto1:' />
								<span><h6>Define o título do texto 1</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="tituloTexto1" />
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="texto1">
								<c:out value='Texto1:' />
								<span><h6>Define o texto 1</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:textarea class="form-control" path="texto1" rows="4" />
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="tituloTexto2">
								<c:out value='Título Texto2:' />
								<span><h6>Define o título do texto 2</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:input class="form-control" path="tituloTexto2" />
							</div>
						</div>
						<div class="linha">
							<form:label class="col-lg-2 control-label" path="texto2">
								<c:out value='Texto1:' />
								<span><h6>Define o texto 2</h6></span>

							</form:label>
							<div class="col-lg-6">
								<form:textarea class="form-control" path="texto2" rows="4" />
							</div>
						</div>



						<br>
					</div>
				</div>
			</div>
		</div>

		<p>
			<button type="button"
				onclick="salvarConfiguracaoAJax(document.getElementById('formConfiguracao'),'${pageContext.request.contextPath}/admin/configuracao/paginaInicial');"
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
				<h4 class="modal-title" id="myModalLabel">Estrofe Página
					Inicial</h4>
			</div>
			<div class="modal-body">
				<form:form id="formEstrofePaginaInicial"
					modelAttribute="estrofePaginaInicial">
					<div class="input-group">
						<span class="input-group-addon">Título Estrofe</span> <input
							type="text" class="form-control"
							placeholder="Digite o título da estrofe" name="tituloEstrofe">
					</div>

					<div class="input-group">
						<span class="input-group-addon">Estrofe</span>
						<textarea rows="4" class="form-control"
							placeholder="Digite a descrição da estrofe." name="estrofe"></textarea>
					</div>

				</form:form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button type="button" id="butaoIncluirTrabalhoRealizado"
					onclick="incluirNovaEstrofe('${pageContext.request.contextPath}/admin/estrofePaginaInicial/incluir','${pageContext.request.contextPath}/admin/configuracao/paginaInicial')"
					class="btn btn-primary">Incluir Estrofe</button>
			</div>
		</div>
	</div>
</div>
<div class="modal fade" id="modalImagem" tabindex="-1" role="dialog"
	aria-labelledby="modalImagem" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">Estrofe Página
					Inicial</h4>
			</div>
			<div class="modal-body">
				<form:form id="formImagemCliente"
					modelAttribute="imagem">
					<input type="hidden" value="${configuracaoPaginaInicial.id}" name="idEntidade">
					<input type="hidden" value="configuracaoPaginaInicial" name="tipoEntidade">
					<div class="input-group">
						<jsp:include page="../includes/inputImage.jsp">
							<jsp:param value="endereco" name="path" />
							<jsp:param value="Imagem" name="label" />
						</jsp:include>
					</div>

				</form:form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
				<button type="button" id="butaoIncluirTrabalhoRealizado"
					onclick="incluirNovaImagem('${pageContext.request.contextPath}/admin/imagem/incluir','${pageContext.request.contextPath}/admin/configuracao/paginaInicial')"
					class="btn btn-primary">Incluir Imagem</button>
			</div>
		</div>
	</div>
</div>
<script
	src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script>
	function incluirNovaEstrofe(ajaxUrl, urlThisPage) {

		$
				.ajax({
					url : ajaxUrl,
					type : 'POST',
					data : $('#formEstrofePaginaInicial,#formConfiguracao')
							.serialize(),
					success : function(mensagem) {
						$('#basicModal').modal('hide');
						bootbox.alert(mensagem, function() {
							$.ajax({
								url : urlThisPage,
								type : 'GET',
								success : function(html) {
									$('#tabelaEstrofes').html(
											$('#tabelaEstrofes', $(html)));

								}

							});

						});
					}
				});
	}
	function incluirNovaImagem(ajaxUrl, urlThisPage) {

		$
				.ajax({
					url : ajaxUrl,
					type : 'POST',
					data : $('#formImagemCliente')
							.serialize(),
					success : function(mensagem) {
						$('#modalImagem').modal('hide');
						bootbox.alert("Incluído com sucesso", function() {
							$.ajax({
								url : urlThisPage,
								type : 'GET',
								success : function(html) {
									$('#tabelaImagens').html(
											$('#tabelaImagens', $(html)));

								}

							});

						});
					}
				});
	}
</script>
</html>