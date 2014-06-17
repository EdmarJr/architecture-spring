<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>

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
			<div class="conteudoProdutos">
				<jsp:include page="../withoutTemplate/paginacaoProdutos.jsp"></jsp:include>
			</div>



		</div>
	</div>
</div>