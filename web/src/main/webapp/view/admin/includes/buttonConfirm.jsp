<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script src='<c:url value="/resources/admin/js/aplicacao/button.js"/>'></script>

<c:set var='label'
		value='${param.label == null ? "" : param.label}' />
<c:set var='urlRedirect'
		value='${param.urlRedirect == null ? "" : param.urlRedirect}' />
		
<c:if test="${not empty urlRedirect}">
<button type="submit" class="btn btn-primary" onclick="window.location.href = '${urlRedirect}'">${label}</button>
</c:if>
<c:if test="${empty urlRedirect}">
<button type="submit" class="btn btn-primary" onclick="desabilitarBotao(this)">${label}</button>
</c:if>