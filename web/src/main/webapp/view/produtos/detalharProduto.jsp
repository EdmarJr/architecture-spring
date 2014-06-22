<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<script
	src='<c:url value="/resources/js/jquery.elevateZoom-3.0.8.min.js"/>'></script>

<style type="text/css">
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

img {
	border-radius: 4px;
}

#body {
	min-height: 500px;
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
<jsp:include page="../includes/menuCategorias.jsp"></jsp:include>
<div class="col-md-9" style="margin-top:3%;margin-bottom: 0px;">
<div class="panel panel-primary"><div class="panel-body" >TESTEEE</div></div>

</div>
<div class="col-md-9" >
	<div class="panel panel-primary">

		<div class="panel-body" id="body">
			<div class="col-md-5" style="margin-top: 2%;">
				<div class="list-group list-group-primary"
					style="width: 80%; margin: 0 auto;">
					<div class="list-group-item"
						style="margin-left: 0px; margin-right: 0px;">
						<img class="imgZoom" style="margin-left: 0px; margin-right: 0px;"
							id="imagemPrincipal"
							data-zoom-image='<c:url value="/resources/${produto.imagemPrincipal.enderecoSeparator}"/>'
							src='<c:url value="/resources/${produto.imagemPrincipal.enderecoSeparator}"/>' />
					</div>
				</div>
			</div>
			<div class="col-md-5" style="margin-top: 2%;">
				<div class="list-group list-group-primary">
					<div class="list-group-item">
						<span> <span class="label label-primary"
							style="text-size: 10">Nome:</span> <span style="float: right">${produto.nome}</span>
						</span>
					</div>
					<div class="list-group-item">
						<span> <span class="label label-primary"
							style="text-size: 10">Código Identificação:</span> <span
							style="float: right">${produto.codigoIdentificacao}</span>
						</span>
					</div>
				</div>
			</div>
			<div class="col-md-2" style="margin-top: 2%;">
				<div class="list-group list-group-primary">

					<a href="#" class="list-group-item">Orçamentar</a> <a href="#"
						class="list-group-item">Voltar</a>
				</div>
			</div>
			<div class="col-md-7">
				<div class="list-group list-group-primary">
					<c:if test="${not empty produto.descricao}">
						<div class="list-group-item" style="display: -webkit-inline-box;">
							${produto.descricao}</div>
					</c:if>
					<div class="list-group-item" style="display: -webkit-box;">
						<c:forEach items="${produto.imagens}" var="imagem">
							<div>
								<img class="imgZoom-mini"
									src='<c:url value="/resources/${imagem.enderecoMiniaturaSeparator}"/>'
									data-zoom-image='<c:url value="/resources/${imagem.enderecoSeparator}"/>' />
							</div>
						</c:forEach>
					</div>

				</div>

			</div>

		</div>
	</div>
</div>
