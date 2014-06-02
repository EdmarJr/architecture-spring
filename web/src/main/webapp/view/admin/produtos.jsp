<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
	function acaoExclusao(idEntidade) {
		var element = document.getElementById("tr" + idEntidade);
		var parentNode = element.parentNode;
		parentNode.removeChild(element);
	}

	function adicionarFiltro() {
		var input = document.createElement("input");
		input.setAttribute("class", "form-control")
		var label = document.createElement("label");
		var divInput = document.createElement("div");
		divInput.setAttribute("class","col-lg-6");
		label.setAttribute("class", "col-lg-2 control-label");
		var select = document.getElementById("selectFiltro");
		var inputFiltro = document.getElementById("inputFiltro");
		input.setAttribute("name", select.value);
		input.setAttribute("id", select.value);
		var elemento = document.getElementById("option" + select.value);
		var labelText = document.createTextNode(elemento.label);
		label.appendChild(labelText);
		var paiElemento = elemento.parentNode;
		paiElemento.removeChild(elemento);
		input.setAttribute("value", inputFiltro.value);
		divInput.appendChild(input);
		document.getElementById("formFiltro").appendChild(label);
		document.getElementById("formFiltro").appendChild(document.createElement("br"));
		document.getElementById("formFiltro").appendChild(divInput);
		document.getElementById("formFiltro").appendChild(document.createElement("br"));
		document.getElementById("formFiltro").appendChild(document.createElement("br"));
	}

	function submeterFiltroAjax(botao, urlAjax) {
		botao.setAttribute("disabled", "disabled");
		$.ajax({
			url : urlAjax,
			data : $("#formFiltro").serialize(),
			type : "POST",
			success : function(html) {
				botao.removeAttribute("disabled");
				$("#resultadoPesquisa").html(
						$('#resultadoPesquisa', $(html)));
			}
		});

	}
</script>


<div>
	<div class="col-md-13">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Produtos</h3>
			</div>
			<div class="panel-body">

				<div class="row">
					<div class="col-sm-6 col-md-8">
						<div class="thumbnail">
							<h3>Filtro Pesquisa</h3>
							<div style="display: flex">
								<input type="text" id="inputFiltro"> <select
									style="width: inherit;" class="form-control" id="selectFiltro">
									<c:forEach items="${parametrosFiltro}" var="nomeFiltro">
										<option id="option${nomeFiltro.codigo}"
											value="${nomeFiltro.codigo}" label="${nomeFiltro.descricao}" />
									</c:forEach>
								</select>
								<button type="button" onclick="adicionarFiltro()"
									class="btn btn-sucess">Adicionar Filtro</button>
							</div>
							<button type="button"
								onclick="submeterFiltroAjax(this,'${pageContext.request.contextPath}/admin/produto/filtrar')"
								class="btn btn-sucess">Pesquisar</button>



						</div>
					</div>
					<div class="col-sm-4 col-md-4">
						<div class="thumbnail">
							<h3>Filtros</h3>
							<div style="display: flex">
								<form:form id="formFiltro" modelAttribute="formFiltro">
							</form:form>
							</div>
						</div>
					</div>
					
				</div>
			</div>

			<div class="linha" id="resultadoPesquisa">
				<c:if test="${pageContext.request.userPrincipal.name != null}">

					<table class='table table-striped table-bordered table-condensed'>
						<thead>
							<tr>
								<th>Nome</th>
								<th>Categoria</th>
								<th>Posição</th>
								<th>Código Identificação</th>
								<th>Ações</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="produto" items="${produtos}">
								<tr id="tr${produto.id}">
									<td>${produto.nome}</td>
									<td>${produto.categoria.nome}</td>
									<td>${produto.posicao}</td>
									<td>${produto.codigoIdentificacao}</td>
									<td><jsp:include page="includes/iconEdit.jsp">
											<jsp:param
												value="${pageContext.request.contextPath}/admin/produto/editar?idProduto=${produto.id}"
												name="urlRedirect" />
										</jsp:include> <jsp:include page="includes/iconDelete.jsp">
											<jsp:param
												value="${pageContext.request.contextPath}/admin/produto/excluir"
												name="ajaxUrl" />
											<jsp:param value="${produto.id}" name="idEntidade" />
										</jsp:include></td>

								</tr>
							</c:forEach>
						</tbody>

					</table>
					<p>
						<jsp:include page="includes/buttonConfirm.jsp">
							<jsp:param value="Incluir Produto" name="label" />
							<jsp:param
								value="${pageContext.request.contextPath}/admin/produto/incluir"
								name="urlRedirect" />
						</jsp:include>
					</p>
				</c:if>
			</div>


			<br>
		</div>
	</div>
</div>
</div>


</html>