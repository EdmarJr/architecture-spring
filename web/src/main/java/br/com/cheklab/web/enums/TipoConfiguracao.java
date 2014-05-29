package br.com.cheklab.web.enums;

public enum TipoConfiguracao {
	DEFAULT(1), MOBILE(2);

	private Long id;

	private TipoConfiguracao(long codigo) {
		this.id = codigo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
