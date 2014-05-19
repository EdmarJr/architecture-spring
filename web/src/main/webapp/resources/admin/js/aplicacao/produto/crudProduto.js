function gerenciarImagens(urlAjax, contextPath) {
	$.ajax({
		url : urlAjax,
		data : $('#formProduto').serialize(),
		type : "POST",
		success : function(data) {
			if (data != "-1") {
				redirecionar(data, contextPath);
			}
		}
	});

	function redirecionar(idEntidade, contextPath) {
		window.location.href = contextPath
				+ '/admin/imagem/imagens?idEntidade=' + idEntidade
				+ '&tipoEntidade=produto';
	}

}

function gerenciarImagensComValidacao(urlAjax, contextPath, validacoes) {
	if (validarRequiredByName(validacoes)) {
		$.ajax({
			url : urlAjax,
			data : $('#formProduto').serialize(),
			type : "POST",
			success : function(data) {
				if (data != "-1") {
					redirecionar(data, contextPath);
				}
			}
		});

		function redirecionar(idEntidade, contextPath) {
			window.location.href = contextPath
					+ '/admin/imagem/imagens?idEntidade=' + idEntidade
					+ '&tipoEntidade=produto';
		}
	}

}

function excluirProduto(idProduto, ajaxUrl) {
	bootbox.confirm("Tem certeza que deseja excluir o produto de id "+idProduto, function(result) {
		function deletarImagem (idImagem) {
		       
		       
		    $.ajax({url: ajaxUrl,
		        data: { "idImagem" : idImagem},
		        type: "POST",
		        success: function(data) {
		        	if(data != "-1") {
		        		var divImagemDelete = document.getElementById("img" + data);
		        		var parentDiv = divImagemDelete.parentNode;
		        		parentDiv.removeChild(divImagemDelete);
		        	}        
		        }
		    });
		      
		    event.preventDefault();
		  }

		}); 
}