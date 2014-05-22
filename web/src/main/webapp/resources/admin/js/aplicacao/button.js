
function desabilitarBotao(node) {
	if(node.form.onsubmit != null && !node.form.onsubmit()) {
		return;
	}
	node.setAttribute("disabled","disabled");
	node.form.submit();
	document.body.style.cursor='progress';
}