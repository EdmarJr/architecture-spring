/**
 * 
 */

function salvarConfiguracaoAJax(form, enderecoAjax, button) {
	button.setAttribute("disabled","disabled");
	$.ajax({
		url : enderecoAjax,
		data : $(form).serialize(),
		type : "POST",
		success: function(idEntidade) {
			button.removeAttribute("disabled");
			bootbox.alert(idEntidade, function(){});
        }
		
	});
	event.preventDefault();
	
}