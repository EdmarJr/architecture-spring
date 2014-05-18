package br.com.cheklab.web.enums;

public enum TipoInclusaoImagemEnum {
	PRODUTO(1,"produto"),
	CATEGORIA(2,"categoria");
	
	private String descricao;
	private Integer codigo;

	private TipoInclusaoImagemEnum(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}


	public Integer getCodigo() {
		return codigo;
	}
	
	public static TipoInclusaoImagemEnum obterPorDescricao(String descricao) {
		TipoInclusaoImagemEnum[] values = values();
		for(TipoInclusaoImagemEnum tipo : values) {
			if(tipo.getDescricao().equals(descricao)) {
				return tipo;
			}
		}
		return null;
	}

	
	
}
