/**
 * 
 */

function salvarConfiguracaoAJax(form, enderecoAjax) {
	$.ajax({
		url : enderecoAjax,
		data : $(form).serialize(),
		type : "POST",
		sucess : function(mensagemSucesso) {
			bootbox.alert(mensagemSucesso, function(){});
		}
		
	});
	
}