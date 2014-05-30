<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<c:set var='path'
		value='${param.path == null ? "categoria" : param.path}' />
	<c:set var='label'
		value='${param.label == null ? " " : param.label}' />
<script >
$(document).ready(
		function() {
			document.getElementById("${path}target").src = document.getElementById("${path}inputHidden").value;
	

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();            
        reader.onload = function (e) {
        	document.getElementById('${path}target').src = e.target.result;
        	document.getElementById('${path}inputHidden').value = e.target.result;
        };
        
        reader.readAsDataURL(input.files[0]);
    }
}

    document.getElementById("${path}buttonUpload").onclick = function() {
    	document.getElementById("${path}imgInp").click();
    };
document.getElementById('${path}imgInp').onchange = function(){
    readURL(this);
};
		});
</script>
<div style="display: inline-block;">
<img id="${path}target" src="#" width="150" height="150" class="img-thumbnail" alt="${label}" /><br/>
<button type="button" id="${path}buttonUpload" title="${label}">${label}</button>
<input style="visibility: hidden" type="file" id="${path}imgInp" />
<form:input id="${path}inputHidden" name="${path}" path="${path}" type="hidden" />
</div>

