package br.com.cheklab.web.enums.filtros;

public enum ParametrosFiltroProdutoEnum {
	ID("Id", "id"), NOME("Nome", "nome"), ATIVO("Ativo", "ativo"), CATEGORIA(
			"Categoria", "categoria"), COD_IDENTIFICACAO(
			"Código Identificação", "codigoIdentificacao");

	private String codigo;
	private String descricao;

	private ParametrosFiltroProdutoEnum(String descricao, String codigo) {
		this.descricao = descricao;
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
