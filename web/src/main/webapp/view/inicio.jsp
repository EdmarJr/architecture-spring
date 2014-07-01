<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">



<div id="headerwrap"
	style='background: url(<c:url value="/resources/${configuracaoPaginaInicial.imagemPaginaInicial.enderecoSeparator}"/>);'>
	<div class="container">
		<div class="row centered">
			<div class="col-lg-8 col-lg-offset-2">
				${configuracaoPaginaInicial.textoImagem}</div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>
<!-- headerwrap -->


<div class="container w">
	<div class="row centered">
		<br> <br>
		<c:forEach items="${configuracaoPaginaInicial.estrofes}" var="estrofe">
			<div class="col-lg-4">
				<i class="fa fa-star"></i>
				<h4>${estrofe.tituloEstrofe}</h4>
				<p>${estrofe.estrofe}</p>
			</div>
			<!-- col-lg-4 -->
		</c:forEach>
	</div>
	<!-- row -->
	<br> <br>
</div>
<!-- container -->


<!-- PORTFOLIO SECTION -->
<div id="dg">
	<div class="container">
		<div class="row centered">
			<h4>ÚLTIMOS TRABALHOS</h4>
			<br>
			<c:forEach items="${configuracaoNossosTrabalhos.trabalhosRealizados}" var="trabalhoRealizado">
			<div class="col-lg-4">
				<div class="tilt">
					<a href="#"><img src="${trabalhoRealizado.imagemTrabalho.enderecoSeparator}" alt="${trabalhoRealizado.nomeCliente}"></a>
				</div>
			</div>
			</c:forEach>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>
<!-- DG -->


<!-- FEATURE SECTION -->
<div class="container wb">
	<div class="row centered">
		<br> <br>
		<div class="col-lg-8 col-lg-offset-2">
			<h4>${configuracaoPaginaInicial.tituloTexto1}</h4>
			<p>${configuracaoPaginaInicial.texto1}</p>
			<p>
				<br /> <br />
			</p>
		</div>
		<div class="col-lg-2"></div>
	</div>
	<!-- row -->
</div>
<!-- container -->


<div id="lg">
	<div class="container">
		<div class="row centered">
			<h4>PRINCIPAIS CLIENTES</h4>
			<div class="col-lg-2 col-lg-offset-1">
					<img src='<c:url value="/resources/${configuracaoPaginaInicial.imagensPrincipaisClientes[0].endereco}"/>' alt="">
				</div>
			<c:forEach
				items="${configuracaoPaginaInicial.imagensPrincipaisClientes}" varStatus="loop"
				var="imagem">
				<c:if test="${loop.index != 0}">
				<div class="col-lg-2">
					<img src='<c:url value="/resources/${imagem.endereco}"/>' alt="">
				</div>
				</c:if>
			</c:forEach>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>
<!-- dg -->


<div id="r">
	<div class="container">
		<div class="row centered">
			<div class="col-lg-8 col-lg-offset-2">
				<h4>${configuracaoPaginaInicial.tituloTexto2}</h4>
				<p>${configuracaoPaginaInicial.texto2}</p>
			</div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>





</html>