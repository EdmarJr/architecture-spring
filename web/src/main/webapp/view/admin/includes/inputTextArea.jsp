<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="form-group warning">

	<c:set var='path'
		value='${param.path == null ? "categoria" : param.path}' />
	<c:set var='label'
		value='${param.label == null ? "Categoria" : param.label}' />
	<c:set var='id'
		value='${param.id == null ? "" : param.id}' />

	<form:label cssClass="col-lg-2 control-label" path="${path}">
		  				${label} <form:errors path="${path}" />
	</form:label>
	<div class="col-lg-6">
		<form:textarea path="${path}" id="${id}" cssClass="form-control" />
	</div>
</div>