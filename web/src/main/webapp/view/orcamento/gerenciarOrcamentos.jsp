<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin/js/fancy/source/jquery.fancybox.css?v=2.1.5"/>' />
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/source/jquery.fancybox.js?v=2.1.5"/>'></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin/js/fancy/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7"/>' />
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"/>'></script>
<script>
	$(document).ready(
			function() {

				$('.fancybox').fancybox();

				$('.fancybox-thumbs')
						.fancybox(
								{
									openEffect : 'none',
									closeEffect : 'none',

									prevEffect : 'none',
									nextEffect : 'none',

									closeBtn : false,

									helpers : {
										title : {
											type : 'inside'
										},
										buttons : {}
									},

									afterLoad : function() {
										this.title = 'Image '
												+ (this.index + 1)
												+ ' of '
												+ this.group.length
												+ (this.title ? ' - '
														+ this.title : '');
									}
								});

				$('.fancybox-thumbs').fancybox({
					prevEffect : 'none',
					nextEffect : 'none',

					closeBtn : true,
					arrows : false,
					nextClick : true,

					helpers : {
						thumbs : {
							width : 20,
							height : 20
						}
					}
				});

			});
</script>
<div class="container w">

	<div class="row centered">
		<br> <br>
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="color: white;">
						<b>Lista de Produtos</b>
					</h3>
				</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="orcamento"
						id="formProdutos">
						<div class="table-responsive">

							<table class="table">
								<tr>
									<th>Código Produto</th>
									<th>Nome</th>
									<th>Imagem</th>
									<th>Quantidade</th>
								</tr>
								<c:forEach items="${orcamentos}" var="orcamentoTemp"
									varStatus="status">
									<tr align="left">
										<form:input type="hidden"
											path="produtosOrcamento[${status.index}].produto.id"
											value="${orcamentoTemp.produto.id}" />
										<td>${orcamentoTemp.produto.codigoIdentificacao}</td>
										<td>${orcamentoTemp.produto.nome}</td>
										<td><a class="fancybox-thumbs"
											data-fancybox-group="thumb"
											title="${produtoTemp.imagemPrincipal.nome}"
											href='<c:url value="/resources/${orcamentoTemp.produto.imagemPrincipal.endereco}"/>'><img
												class="imgMiniaturaFancy" width="50px"
												src='<c:url value="/resources/${orcamentoTemp.produto.imagemPrincipal.enderecoMiniatura}"/>' /></a></td>
										<td><form:input id="quantidadeProdutos" class="quantidadeProdutos"
												path="produtosOrcamento[${status.index}].quantidadeProdutos" /></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<button type="button" class="btn btn-primary"
							onclick="solicitarOrcamento()">Solicitar Orçamento</button>
						<button type="button" class="btn btn-default"
							onclick="window.location.href = '${pageContext.request.contextPath}/produtos'">
							Adicionar Mais Produtos</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="basicModal" tabindex="-1" role="dialog"
		aria-labelledby="basicModal" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Informações do
						Cliente</h4>
				</div>
				<div class="modal-body">
					<form:form id="formCliente" modelAttribute="cliente">
						<div class="input-group">
							<span class="input-group-addon">Nome</span> <input type="text"
								class="form-control" placeholder="Digite seu nome completo"
								name="nome">
						</div>
						<div class="input-group">
							<span class="input-group-addon">Telefone</span> <input
								id="telefone" type="text" class="form-control"
								placeholder="Digite um telefone para contato" name="telefone">
						</div>
						<div class="input-group">
							<span class="input-group-addon">E-Mail</span> <input type="text"
								class="form-control"
								placeholder="Digite um endereço de e-mail para contato"
								name="email">
						</div>
						<c:if test="${configuracaoPaginaOrcamento.indicacaoHabilitada}">
							<div class="input-group">
								<span class="input-group-addon">Indicação</span> <input
									type="text" class="form-control"
									placeholder="Digite o nome de quem te indicou a comprar com a nossa empresa"
									name="indicacao">
							</div>
						</c:if>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button type="button"
						onclick="enviarSolicitacaoOrcamento('${pageContext.request.contextPath}/incluirOrcamento')"
						class="btn btn-primary">Enviar Solicitação de Orçamento</button>
				</div>
			</div>
		</div>
	</div>
	<!-- row -->
	<br> <br>
</div>
<script
	src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/jquery.mask.min.js"/>'></script>
<script type="text/javascript">
	$('#quantidadeProdutos').mask('9999999999');
	$('#telefone').mask("(99) 9999-99999");
</script>
<script>
	function solicitarOrcamento() {
		camposPreenchidos = true;
		$('.quantidadeProdutos').each(function(index) {
			$(this).css({
				'border-color' : ''
			});
		});
		$('.quantidadeProdutos').each(function(index) {
			if ($(this).val() == '') {
				$(this).css({
					'border-color' : 'red'
				});
				camposPreenchidos = false;
			}
		});
		if (camposPreenchidos) {
			$('#basicModal').modal('show');
		}
	}

	function validarCampos() {
		$('input[name=nome]').css({
			'border-color' : '#cccccc'
		});
		$('input[name=telefone]').css({
			'border-color' : '#cccccc'
		});
		$('input[name=email]').css({
			'border-color' : '#cccccc'
		});
		if ($('input[name=nome]').val() == '') {
			$('input[name=nome]').css({
				'border-color' : 'red'
			});
			return false;
		}
		if ($('input[name=telefone]').val() == '') {
			$('input[name=telefone]').css({
				'border-color' : 'red'
			});
			return false;
		}
		if ($('input[name=email]').val() == '') {
			$('input[name=email]').css({
				'border-color' : 'red'
			});
			return false;
		}
		
		return true;
	}

	function enviarSolicitacaoOrcamento(ajaxUrl) {
		if (!validarCampos()) {
			return;
		}
		var dataString = $("#formProdutos, #formCliente").serialize();

		$
				.ajax({
					url : ajaxUrl,
					data : dataString,
					type : "POST",
					success : function(data) {
						$('#basicModal').modal('hide');
						bootbox
								.alert(
										"Solicitacao de orçamento enviado com sucesso!.",
										function() {
											window.location.href = '${pageContext.request.contextPath}/orcamentos'
										});
					}
				});
		event.preventDefault();

	}

	
</script>