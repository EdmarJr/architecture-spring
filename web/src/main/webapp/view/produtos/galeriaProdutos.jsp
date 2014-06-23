<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<script type="text/javascript"
	src='<c:url value="/resources/js/jquery.infinitescroll.min.js"/>'></script>
<jsp:include page="../includes/menuCategorias.jsp"></jsp:include>
<script
	src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script>

function validarMinimoTresLetrasNaPesquisa() {
	var valor = $('#nomeForm').val();
	if(valor.length < 3) {
		bootbox.alert("Campo pesquisa deve ter no mínimo 3 caracteres", function(){});
		return false;
	}
	return true;
}

	function comandoPesquisar(event, form, enderecoAjax) {
		if (event.keyCode == 13) {
		if(!validarMinimoTresLetrasNaPesquisa()) {
			return;
		}
			$.ajax({
				url : enderecoAjax,
				data : $(form).serialize(),
				method : 'POST',
				success : function(html) {
					$('#conteudoProdutos')
							.html($('#conteudoProdutos', $(html)));
					ajustarEnderecoScroll();

				},error: function(jqXHR, exception) {
			        if (jqXHR.status === 0) {
			            alert('Not connect.\n Verify Network.');
			        } else if (jqXHR.status == 404) {
			            alert('Requested page not found. [404]');
			        } else if (jqXHR.status == 500) {
			            alert('Internal Server Error [500].');
			        } else if (exception === 'parsererror') {
			            alert('Requested JSON parse failed.');
			        } else if (exception === 'timeout') {
			            alert('Time out error.');
			        } else if (exception === 'abort') {
			            alert('Ajax request aborted.');
			        } else {
			            alert('Uncaught Error.\n' + jqXHR.responseText);
			        }
			    }
			});
		}

	}

	function ajustarEnderecoScroll() {
		var endereco = $('#pagination a').attr('href');
		var posicaoInsercao = endereco.indexOf("?") + 1;
		var primeiraParte = endereco.substring(0, posicaoInsercao);
		var segundaParte = endereco.substring(posicaoInsercao, endereco.length);
		var novoEndereco = primeiraParte + "criterioPesquisa="
				+ $('#nomeForm').val() + "&" + segundaParte;
		$('#pagination a').attr('href', novoEndereco);
	}
</script>

<div class="col-md-9" style="margin-top: 3%; margin-bottom: 0px;">

	<div class="panel panel-primary" style="background: #428bca;">
		<div class="panel-body">
			<form:form modelAttribute="produtoPesquisa" onsubmit="return false;">
				<div class="input-group">
					<span class="input-group-addon">Pesquisa</span>
					<form:input class="form-control"
						placeholder="Digite o nome do produto que você está procurando"
						onkeypress="comandoPesquisar(event,this,'${pageContext.request.contextPath}/produtos/filtrar');"
						path="nome" id="nomeForm" />
				</div>
			</form:form>
		</div>
	</div>

</div>
<div class="col-md-9" style="float: left;">
	<div class="panel panel-primary">
		<c:if test="${not empty produtos[0].categoria.descricao}">
			<div class="panel-heading">
				<div class="resizeFonte">${produtos[0].categoria.descricao}</div>
			</div>
		</c:if>

		<div id="containerIas" class="panel-body panel-primary">
			<div id="conteudoProdutos">
				<jsp:include page="../withoutTemplate/paginacaoProdutos.jsp"></jsp:include>
			</div>
			<div id="pagination">
				<a
					href='http://localhost:8080${pageContext.request.contextPath}/produtosPaginados/pagina?idCategoria=${produtos[0].categoria.id}&idPagina=2'
					class="next">next</a>
			</div>
		</div>
		<div id="lastPostsLoader"></div>



	</div>
</div>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						function lastAddedLiveFunc() {
							$('div#lastPostsLoader').html(
									'<img src="bigLoader.gif"/>');

							$
									.get(
											$('#pagination a').attr('href'),
											function(data) {

												if (data != "") {
													var produto = $(".produto");
													var ultimoProduto = produto[produto.length - 1];
													$(ultimoProduto).append(
															$('.produto',
																	$(data)));
													var url = $('#pagination a')
															.attr('href');
													var numeroPagina = url
															.substring(
																	url.length - 1,
																	url.length);
													var urlInteira = url
															.substring(
																	0,
																	url.length - 1);
													var urlInteira = urlInteira
															+ (parseInt(numeroPagina) + 1);
													$('#pagination a').attr(
															'href', urlInteira);
												}
												$('div#lastPostsLoader')
														.empty();
											});
						}
						;

						$(window)
								.scroll(
										function() {

											var wintop = $(window).scrollTop(), docheight = $(
													document).height(), winheight = $(
													window).height();
											var scrolltrigger = 0.99;

											if ((wintop / (docheight - winheight)) > scrolltrigger) {
												lastAddedLiveFunc();
											}
										});
					});

	
</script>