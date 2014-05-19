/**
 * 
 */function validarRequiredByName(names) {
		apagarMensagens();
		var submeter = true;
		for (var i = 0; i < names.length; i++) {
			nome = names[i];
			var elements = document.getElementsByName(nome);
			for (var j = 0; j < elements.length; j++) {
				element = elements[j];
				if (element.value == "") {
					submeter = false;
					adicionarMensagem('Campo ' + nome + ' é obrigatório');
					break;
				}
			}
		}
		if (submeter) {
			return true;
		}
		return false;
	}

	function apagarMensagens() {
		var ul = document.getElementById('messages');
		while (ul.firstChild) {
			ul.removeChild(ul.firstChild);
		}
	}

	function adicionarMensagem(mensagem) {
		var ul = document.getElementById('messages');
		var li = document.createElement('li');
		li.appendChild(document.createTextNode(mensagem));
		li.setAttribute('style', 'color:red');
		ul.appendChild(li);
	}