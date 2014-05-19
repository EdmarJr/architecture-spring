
function excluirEntidade(idEntidade, ajaxUrl) {
	bootbox.confirm("Tem certeza que deseja excluir a o registro de id "+idEntidade+" ?", function(result) {
		if(result) {
		
		    $.ajax({url: ajaxUrl,
		        data: { 'idEntidade' : idEntidade},
		        type: "POST",
		        success: function(idEntidade) {
		        	acaoExclusao(idEntidade);     
		        }
		    });
		      
		    event.preventDefault();
		  }

	});
	
}