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
					<form:form method="post"
						action="${pageContext.request.contextPath}/incluirOrcamento"
						modelAttribute="orcamento">
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
												value="${orcamentoTemp.produto.id}"/>
										<td>${orcamentoTemp.produto.codigoIdentificacao}</td>
										<td>${orcamentoTemp.produto.nome}</td>
										<td><a class="fancybox-thumbs"
											data-fancybox-group="thumb"
											title="${produtoTemp.imagemPrincipal.nome}"
											href='<c:url value="/resources/${orcamentoTemp.produto.imagemPrincipal.endereco}"/>'><img
												class="imgMiniaturaFancy" width="50px"
												src='<c:url value="/resources/${orcamentoTemp.produto.imagemPrincipal.enderecoMiniatura}"/>' /></a></td>
										<td><form:input
												path="produtosOrcamento[${status.index}].quantidadeProdutos"/></td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<form:button class="btn btn-primary"> Solicitar Orçamento </form:button>
						<button type="button" class="btn btn-default" onclick="window.location.href = '${pageContext.request.contextPath}/produtos'"> Adicionar Mais Produtos </button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- row -->
	<br> <br>
</div>