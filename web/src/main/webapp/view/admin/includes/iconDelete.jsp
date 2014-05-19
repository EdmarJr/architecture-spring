<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src='<c:url value="/resources/admin/js/bootbox/bootbox.min.js"/>'></script>
<script src='<c:url value="/resources/admin/js/aplicacao/produto/crudGeneric.js"/>'></script>
<style type="text/css">
.iconDeleteAboveImg:HOVER {
	background-color: red;
	cursor: pointer;
}
</style>
<c:set var='ajaxUrl'
		value='${param.ajaxUrl == null ? "" : param.ajaxUrl}' />
	<c:set var='idEntidade'
		value='${param.idEntidade == null ? " " : param.idEntidade}' />
		
		<img
			id="icondeleteimg${imagem.id}" class="iconDeleteAboveImg" onclick='excluirEntidade("${idEntidade}","${ajaxUrl}")'
			src='<c:url value="/resources/admin/icons/delete.png"/>' alt="Excluir" width=.. height=.. />