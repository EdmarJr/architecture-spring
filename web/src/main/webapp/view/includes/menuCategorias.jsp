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
.menuCategorias{
position: relative;
  float: right;
  padding: 9px 10px;
  margin-top: 8px;
  margin-right: 15px;
  margin-bottom: 8px;
 background-color: #428bca;
  border: 1px solid transparent;
  border-radius: 4px;
}
</style>


<div class="col-md-3" style="margin-top: 2%;">
	<div class="categorias">

		<div class="panel-body">
		<div>
				<button type="button" class="menuCategorias" data-toggle="collapse"
					data-target="#navbarCategorias">
				</button>
			</div>
			<nav id="navbarCategorias" class="navbar-collapse collapse">
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