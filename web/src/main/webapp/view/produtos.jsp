<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<div id="headerwrap">
	<div class="container">
		<div class="row centered">
			<div class="col-lg-8 col-lg-offset-2">
				<c:forEach var="produto" items="${produtos}">
					${produto.nome}
				</c:forEach>
			</div>
		</div>
		<!-- row -->
	</div>
	<!-- container -->
</div>
<!-- headerwrap -->






</html>