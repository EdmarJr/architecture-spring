<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="container w">
	<div class="row centered">
		<br> <br>
		<div class="col-md-12">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title" style="color: white;">
						<b>Lista de Produtos</b>
					</h3>
				</div>
				<div class="panel-body">
					<form:form method="post"
						action="${pageContext.request.contextPath}/incluirOrcamento"
						modelAttribute="orcamento">
						<table>
							<tr>
								<th>Código Produto</th>
								<th>Nome</th>
								<th>Quantidade</th>
							</tr>
							<c:forEach items="${orcamentos}" var="orcamentoTemp"
								varStatus="status">
								<tr>
									<td><form:input path="produtosOrcamento[${status.index}].produto.codigoIdentificacao" value="${orcamentoTemp.produto.codigoIdentificacao}"/></td>
									<td><form:input path="produtosOrcamento[${status.index}].produto.nome" value="${orcamentoTemp.produto.nome}"/></td>
									<td><form:input path="produtosOrcamento[${status.index}].quantidadeProdutos"/></td>
								</tr>
							</c:forEach>
						</table>
								<form:button> Enviar </form:button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
	<!-- row -->
	<br> <br>
</div>