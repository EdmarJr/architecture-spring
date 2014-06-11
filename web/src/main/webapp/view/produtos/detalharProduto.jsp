<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script
	src='<c:url value="/resources/js/jquery.elevateZoom-3.0.8.min.js"/>'></script>
<style type="text/css">
a {
	color: #0066CC;
	text-decoration: none;
}

a:hover {
	color: #CC0000;
	text-decoration: underline;
}

.imgZoom {
	display: block;
	max-width: 100%;
	height: auto;
	width: 250px;
}

.imgZoom-mini {
	display: block;
	max-width: 100%;
	height: auto;
	width: 50px;
}
</style>

<script type="text/javascript">
	$(document).ready(function() {

		$(".imgZoom").elevateZoom({
			tint : true,
			tintColour : '#F90',
			tintOpacity : 0.5
		});
		$(".imgZoom-mini").elevateZoom({
			tint : true,
			tintColour : '#F90',
			tintOpacity : 0.5
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
			<div class="col-md-5" style="margin-top: 2%;">
				<div class="panel panel-primary">
					<div class="panel-body" style="width: 80%; margin: 0 auto;">
						<img class="imgZoom" style="margin-left: 0px; margin-right: 0px;"
							data-zoom-image='<c:url value="/resources/${produto.imagemPrincipal.enderecoSeparator}"/>'
							src='<c:url value="/resources/${produto.imagemPrincipal.enderecoSeparator}"/>' />
					</div>
					
				</div>
			</div>
			<div class="col-md-5" style="margin-top: 2%; ">
				<div class="list-group list-group-primary" style="border:1px solid;border-color: #428bca;border-radius:4px;">
							<div class="list-group-item"><span> <span
									class="label label-default" style="text-size: 10">Nome:</span>
									<span style="float: right">${produto.nome}</span>
							</span></div>
							<div class="list-group-item"><span> <span
									class="label label-default" style="text-size: 10">Código Identificação:</span>
									<span style="float: right">${produto.codigoIdentificacao}</span>
							</span></div>
							<div class="list-group-item"><span> <span
									class="label label-default" style="text-size: 10">Email:</span>
									<span style="float: right">${orcamentoSelecionado.cliente.email}</span>
							</span></div>
				</div>
			</div>	
			<div class="col-md-2" style="margin-top: 2%; ">
				<div class="list-group list-group-primary" style="border:1px solid;border-color: #428bca;border-radius:4px;">

					<a href="#" class="list-group-item list-group-item-info">Fechar
						Orçamento</a> <a href="#" class="list-group-item list-group-item-info">Responder
						Orçamento</a>
				</div>
			</div>	
			<div class="col-md-7" style="margin-top: 2%; border:1px solid;border-color: #428bca;border-radius:4px;">
				<c:forEach items="${produto.imagens}" var="imagem">
							<img class="imgZoom-mini"
								src='<c:url value="/resources/${imagem.enderecoMiniaturaSeparator}"/>'
								data-zoom-image='<c:url value="/resources/${imagem.enderecoSeparator}"/>' />
						</c:forEach>
			</div>	

		</div>
	</div>
</div>
