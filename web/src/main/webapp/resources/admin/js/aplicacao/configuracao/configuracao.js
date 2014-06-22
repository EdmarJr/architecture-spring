/**
 * 
 */

function salvarConfiguracaoAJax(form, enderecoAjax) {
	$.ajax({
		url : enderecoAjax,
		data : $(form).serialize(),
		type : "POST",
		success : function(mensagemSucesso) {
			bootbox.alert(mensagemSucesso, function(){});
		}
		
	});
	
}