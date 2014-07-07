/**
 * 
 */

function salvarConfiguracaoAJax(form, enderecoAjax) {
	$('form').css('cursor', 'progress');
	$.ajax({
		url : enderecoAjax,
		data : $(form).serialize(),
		type : "POST",
		success : function(mensagemSucesso) {
			bootbox.alert(mensagemSucesso, function(){});
			$('form').css('cursor', 'auto');
		}
		
	});
	
}