<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<c:if test="${!ajaxRequest}">
<html>
</c:if>
	<div id="formsContent">
		<h2>Forms</h2>
		<p>
			See the <code>org.springframework.samples.mvc.form</code> package for the @Controller code	
		</p>
		<form:form id="form" method="post" modelAttribute="produto" cssClass="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	
		  		</c:if>
		  		<s:bind path="*">
		  			<c:if test="${status.error}">
				  		<div id="message" class="error">Form has errors</div>
		  			</c:if>
		  		</s:bind>
			</div>
		  	<fieldset>
		  		<legend>Personal Info</legend>
		  		<form:label path="nome">
		  			Nome <form:errors path="nome" cssClass="error" />
		 		</form:label>
		  		<form:input path="nome" />

		  		<form:label path="codigoIdentificação">
		  			Cod. Identificação <form:errors path="codigoIdentificação" cssClass="error" />
		 		</form:label>
		  		<form:input path="codigoIdentificação" />
		  		
		  		<form:label path="descricao">
		  			Descrição <form:errors path="descricao" cssClass="error" />
		 		</form:label>
		  		<form:input path="descricao" />


		  	</fieldset>


			<p><button type="submit">Submit</button></p>
		</form:form>
	</div>
<c:if test="${!ajaxRequest}">
</html>
</c:if>