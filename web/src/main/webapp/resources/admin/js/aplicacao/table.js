function selecionarRow(e) {
	$(e.parent).children().attr("class","");
	$(e.target).attr("class","active");
}

