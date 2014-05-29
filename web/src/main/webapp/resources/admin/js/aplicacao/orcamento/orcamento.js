function mostrarOrcamentoTelaAjax(element, enderecoAjax) {
		selecionarRow(element);
		onClickTable(element, enderecoAjax);
	}

	function onClickTable(elemento, enderecoAjax) {
		$
				.ajax({
					url : enderecoAjax,
					data : {
						'idOrcamento' : elemento.id
					},
					type : "POST",
					success : function(html) {
						$('#conteudoDetalhar').empty();
						$('#conteudoDetalhar').html(
								$('#conteudoDetalhar', $(html)));
					}
				});

		event.preventDefault();
	}