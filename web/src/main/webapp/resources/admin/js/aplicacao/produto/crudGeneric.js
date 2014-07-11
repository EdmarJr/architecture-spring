
function excluirEntidade(idEntidade, ajaxUrl) {
	bootbox.confirm("Tem certeza que deseja excluir a o registro de id "+idEntidade+" ?", function(result) {
		if(result) {
			$('body').css('cursor','progress');
		    $.ajax({url: ajaxUrl,
		        data: { 'idEntidade' : idEntidade},
		        type: "POST",
		        success: function(idEntidade) {
		        	$('body').css('cursor','auto');
		        	acaoExclusao(idEntidade);     
		        }
		    });
		      
		    event.preventDefault();
		  }

	});
	
}