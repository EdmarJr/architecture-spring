function selecionarRow(e, onClickFuncao) {
	$(e.parent).children().attr("class","");
	$(e.target).attr("class","active");
	onClickFuncao();
}