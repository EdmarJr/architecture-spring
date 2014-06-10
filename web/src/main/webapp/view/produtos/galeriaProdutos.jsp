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
</script>

<div class="col-md-3" style="margin-top: 2%;">
	<div class="panel panel-primary">

		<div class="panel-body">
			<nav>
				<ul class="nav nav-pills nav-stacked span2">
					<c:forEach items="${categorias}" var="categoria">
						<li><a
							href="${pageContext.request.contextPath}/produtos?idCategoria=${categoria.id}">${categoria.nome}</a></li>
					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-md-9" style="margin-top: 2%;">
	<div class="panel panel-primary">

		<div class="panel-body">
			<c:forEach items="${produtos}" var="produto">
				<div class="col-md-3" style="margin-top: 2%;">
					<div class="panel panel-primary">
						<div class="panel-heading">${produto.nome}</div>
						<div class="panel-body" style="width: 80%; margin: 0 auto;">
							<a class="fancybox-thumbs" data-fancybox-group="thumb"
								title="${produto.imagemPrincipal.nome}"
								href='<c:url value="/resources/${produto.imagemPrincipal.endereco}"/>'><img
								class="imgMiniaturaFancy" width="150px"
								src='<c:url value="/resources/${produto.imagemPrincipal.enderecoMiniatura}"/>' /></a>
						</div>
						<div class="panel-footer">
							<div style="display: flex">
								<jsp:include page="../includes/buttonConfirm.jsp">
									<jsp:param
										value="${pageContext.request.contextPath}/produtos/detalhar?idProduto=${produto.id}"
										name="urlRedirect" />
									<jsp:param value="Detalhar" name="label" />
								</jsp:include>
								<button type="submit" class="btn btn-primary">Orçamentar</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>