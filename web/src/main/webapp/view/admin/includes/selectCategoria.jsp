<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="form-group">
	<c:set var='path'
		value='${param.path == null ? "categoria" : param.path}' />
	<c:set var='label'
		value='${param.label == null ? "Categoria" : param.label}' />

	<form:label class="col-lg-2 control-label" path="${path}">
		<c:out value='${label}' />

	</form:label>
	<div class="col-lg-6">
		<form:select class="form-control" path="${path}">
			<form:option value="" label=""/>
			<c:forEach items="${categoriasSelect}" var="categoria">
				<form:option label="${categoria.nome}"
					value="${categoria.id}" />
				<c:if test="${not empty categoria.categoriasFilha}">
   				<c:forEach items="${categoria.categoriasFilha}" var="categoriaFilha">
   				<form:option label='--${categoriaFilha.nome}'
					value="${categoriaFilha.id}" />
   				</c:forEach>
			</c:if>
			</c:forEach>
		</form:select>
	</div>
</div>