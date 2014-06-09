<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var='produtoTemp'
		value='${param.produtoInput == null ? null : param.produtoInput}' />
<div class="col-md-3" style="margin-top: 2%;">
	<div class="panel panel-primary">
		<div class="panel-body">
			<a class="fancybox-thumbs" data-fancybox-group="thumb"
				title="${produtoTemp.imagemPrincipal.nome}"
				href='<c:url value="/resources/${produtoTemp.imagemPrincipal.endereco}"/>'><img
				class="imgMiniaturaFancy" width="150px"
				src='<c:url value="/resources/${produtoTemp.imagemPrincipal.enderecoMiniatura}"/>' /></a>
		</div>
	</div>
</div>