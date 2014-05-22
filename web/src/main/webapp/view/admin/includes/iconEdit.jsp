<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style type="text/css">
.iconEditAboveImg:HOVER {
	background-color: black;
	cursor: pointer;
}
</style>
<c:set var='urlRedirect'
		value='${param.urlRedirect == null ? "" : param.urlRedirect}' />
	
		
		<img
			id="icondeleteimg${imagem.id}" class="iconEditAboveImg" onclick="window.location.href = '${urlRedirect}'"
			src='<c:url value="/resources/admin/icons/pencil.png"/>' alt="Alterar" width=.. height=.. />