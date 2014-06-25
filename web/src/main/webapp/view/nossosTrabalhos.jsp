<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<img width="300px" class="img-rounded" src='<c:url value="/resources/${configuracaoPaginaInicial.imagemTrabalho.endereco}"/>' alt="">
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