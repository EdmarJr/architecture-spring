<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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


<div id="blue">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-8 col-lg-offset-2">
				<h4>${configuracaoNossosTrabalhos.tituloPagina}</h4>
				<p>${configuracaoNossosTrabalhos.subTituloPagina}</p>
				</div>
			</div><!-- row -->
		</div><!-- container -->
	</div><!--  bluewrap -->


	<div class="container desc">
		<c:forEach items="${configuracaoNossosTrabalhos.trabalhosRealizados}" var="trabalhoRealizado">
		<div class="row">
			<br><br>
			<div class="col-lg-6 centered">
			<a class="fancybox-thumbs" data-fancybox-group="thumb"
						title="Cliente: ${trabalhoRealizado.nomeCliente}"
						href='<c:url value="/resources/${trabalhoRealizado.imagemTrabalho.enderecoSeparator}"/>'><img
						class="img-rounded" width="300px" 
						src='<c:url value="/resources/${trabalhoRealizado.imagemTrabalho.enderecoMiniaturaSeparator}"/>' /></a>
			
			</div><!-- col-lg-6 -->
			<div class="col-lg-6">
				<h4>${trabalhoRealizado.nomeCliente}</h4>
				<p>${trabalhoRealizado.descricaoTrabalho1}</p>
				<p>${trabalhoRealizado.descricaoTrabalho2}</p>
				<p>
					<i class="fa fa-circle-o" style="color:#3498db"></i>${trabalhoRealizado.caracteristica1}<br/>
					<i class="fa fa-circle-o" style="color:#3498db"></i>${trabalhoRealizado.caracteristica2}<br/>
					<i class="fa fa-circle-o" style="color:#3498db"></i>${trabalhoRealizado.caracteristica3}<br/>
				</p>
			</div>
		</div><!-- row -->
		<br><br>
		<hr>
		</c:forEach>
		
			</div><!-- container -->

	
	<div id="r" style="background: #808080 ;">
		<div class="container">
			<div class="row centered">
				<div class="col-lg-8 col-lg-offset-2">
					<h4>${configuracaoNossosTrabalhos.tituloRodape}</h4>
					<p>${configuracaoNossosTrabalhos.subTituloRodape}</p>
				</div>
			</div><!-- row -->
		</div><!-- container -->
	</div><! -- r wrap -->