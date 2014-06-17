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

	function comandoOrcamentar(idProduto,urlPostAjax) {
		
			
		    $.ajax({url: urlPostAjax,
		        data: { 'idProduto' : idProduto},
		        type: "POST",
		        success: function(idEntidade) {
			        if(idEntidade == 'sucesso') {
			        	bootbox.alert("Produto adicionado a sua lista de solicitações de orçamentos, entre no menu \"Gerenciar Orcamentos\" para enviar a solicitação de orçamento.", function() {
			        		});
				        }
		        	
		        }
		    });
		      
		    event.preventDefault();
		  
	}
</script>

<div class="col-md-3" style="margin-top: 2%;">
	<div class="categorias">

		<div class="panel-body">
			<nav>
				<ul class="nav nav-pills nav-stacked span2">
					<c:forEach items="${categorias}" var="categoria">
						<c:if test="${not empty categoria.categoriasFilha}">
							<li class="itemCategoria"><a class="dropdown-toggle"
								data-toggle="dropdown" href="#">${categoria.nome}<b
									class="caret"></b></a>
								<ul class="dropdown-menu">
									<c:forEach items="${categoria.categoriasFilha}"
										var="categoriaF">
										<li><a
											href="${pageContext.request.contextPath}/produtos?idCategoria=${categoriaF.id}">${categoriaF.nome}</a></li>

									</c:forEach>
								</ul></li>
						</c:if>
						<c:if test="${empty categoria.categoriasFilha}">
							<li class="itemCategoria"><a
								href="${pageContext.request.contextPath}/produtos?idCategoria=${categoria.id}">${categoria.nome}</a></li>
						</c:if>


					</c:forEach>
				</ul>
			</nav>
		</div>
	</div>
</div>
<div class="col-md-9" style="margin-top: 2%; float: left;">
	<div class="panel panel-primary">

		<div class="panel-body panel-primary">
			
			
			
			
		</div>
	</div>
</div>