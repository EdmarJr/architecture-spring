<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin/js/fancy/source/jquery.fancybox.css?v=2.1.5"/>' />
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/source/jquery.fancybox.js?v=2.1.5"/>'></script>
<link rel="stylesheet" type="text/css"
	href='<c:url value="/resources/admin/js/fancy/source/helpers/jquery.fancybox-thumbs.css?v=1.0.7"/>' />
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/source/helpers/jquery.fancybox-thumbs.js?v=1.0.7"/>'></script>
<script
	src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script type="text/javascript"
	src='<c:url value="/resources/admin/js/fancy/jquery.mousewheel-3.0.6.pack.js"/>'></script>
	
<style>
.imgMiniaturaFancy {
	display: inline-block;
	max-width: 100%;
	height: auto;
	padding: 4px;
	line-height: 1.428571429;
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 4px;
	-webkit-transition: all .2s ease-in-out;
	transition: all .2s ease-in-out;
	position: relative;
	z-index: 1;
}

.categorias {
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.05);
	background-color: #f2f2f2
}

.itemCategoria {
	border-radius: 4px;
	background-color: #428bca;
}
</style>
<script type="text/javascript">
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

	function comandoOrcamentar(idProduto, urlPostAjax, element) {
		$('#content').css('cursor','progress');
		$
				.ajax({
					url : urlPostAjax,
					data : {
						'idProduto' : idProduto
					},
					type : "POST",
					success : function(idEntidade) {
						if (idEntidade == 'sucesso') {
							$(element).fadeToggle('slow');
						}
						$('#content').css('cursor','auto');

					}
				});

		event.preventDefault();

	}
</script>

<c:forEach items="${produtos}" var="produtoTemp">
	<div class="produto">
		<div class="col-md-3" style="margin-top: 2%;">
			<div class="panel panel-primary">
				<div class="panel-heading" style="max-height: 42px;">
				<div class="resizeFonte">${produtoTemp.nome}</div></div>
				<div class="panel-body" style="width: 80%; margin: 0 auto;">
					<a class="fancybox-thumbs" data-fancybox-group="thumb"
						title="${produtoTemp.imagemPrincipal.nome}"
						href='<c:url value="/resources/${produtoTemp.imagemPrincipal.endereco}"/>'><img
						class="imgMiniaturaFancy" width="150px"
						src='<c:url value="/resources/${produtoTemp.imagemPrincipal.enderecoMiniatura}"/>' /></a>
				</div>
				<div class="panel-footer panel-primary">
					<div style="display: flex">
						<jsp:include page="../includes/buttonConfirm.jsp">
							<jsp:param
								value="${pageContext.request.contextPath}/produtos/detalhar?idProduto=${produtoTemp.id}"
								name="urlRedirect" />
							<jsp:param value="Detalhar" name="label" />
						</jsp:include>
						<button type="button" id="botaoOrcamentar" class="btn btn-primary"
							onclick="comandoOrcamentar('${produtoTemp.id}','${pageContext.request.contextPath}/adicionarProdutoOrcamento',this)">Orçamentar</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:forEach>
	


