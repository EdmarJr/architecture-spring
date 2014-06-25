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
			<h4>LATEST WORKS</h4>
			<br>
			<div class="col-lg-4">
				<div class="tilt">
					<a href="#"><img src="assets/img/p01.png" alt=""></a>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="tilt">
					<a href="#"><img src="assets/img/p03.png" alt=""></a>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="tilt">
					<a href="#"><img src="assets/img/p02.png" alt=""></a>
				</div>
			</div>
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
			<h4>WE CREATE FIRST CLASS DESIGN</h4>
			<p>By being true to the brand we represent, we elevate the
				audiences’ relationship to it. Like becomes love becomes a
				passion. Passion becomes advocacy. And we see the brand blossom from
				within, creating a whole story the audience embraces. That’s when
				the brand can truly flex its muscles.</p>
			<p>
				<br /> <br />
			</p>
		</div>
		<div class="col-lg-2"></div>
		<div class="col-lg-10 col-lg-offset-1">
			<img class="img-responsive" src="assets/img/munter.png" alt="">
		</div>
	</div>
	<!-- row -->
</div>
<!-- container -->


<div id="lg">
	<div class="container">
		<div class="row centered">
			<h4>PRINCIPAIS CLIENTES</h4>
			<div class="col-lg-2 col-lg-offset-1">
				<img src="assets/img/c01.gif" alt="">
			</div>
			<div class="col-lg-2">
				<img src="assets/img/c02.gif" alt="">
			</div>
			<div class="col-lg-2">
				<img src="assets/img/c03.gif" alt="">
			</div>
			<div class="col-lg-2">
				<img src="assets/img/c04.gif" alt="">
			</div>
			<div class="col-lg-2">
				<img src="assets/img/c05.gif" alt="">
			</div>
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
				<h4>WE ARE STORYTELLERS. BRANDS ARE OUR SUBJECTS. DESIGN IS OUR
					VOICE.</h4>
				<p>We believe ideas come from everyone, everywhere. At BlackTie,
					everyone within our agency walls is a designer in their own right.
					And there are a few principles we believe—and we believe everyone
					should believe—about our design craft. These truths drive us,
					motivate us, and ultimately help us redefine the power of design.</p>
			</div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>





</html>