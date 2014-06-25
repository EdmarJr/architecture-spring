package br.com.cheklab.web.entity.configuracoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "estrofe_pagina_inicial")
@Entity
public class EstrofePaginaInicial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String tituloEstrofe;
	@Column(length = 5000)
	private String estrofe;
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private ConfiguracaoPaginaInicial configuracaoPaginaInicial;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloEstrofe() {
		return tituloEstrofe;
	}

	public void setTituloEstrofe(String tituloEstrofe) {
		this.tituloEstrofe = tituloEstrofe;
	}

	public String getEstrofe() {
		return estrofe;
	}

	public void setEstrofe(String estrofe) {
		this.estrofe = estrofe;
	}

	public ConfiguracaoPaginaInicial getConfiguracaoPaginaInicial() {
		return configuracaoPaginaInicial;
	}

	public void setConfiguracaoPaginaInicial(
			ConfiguracaoPaginaInicial configuracaoPaginaInicial) {
		this.configuracaoPaginaInicial = configuracaoPaginaInicial;
	}

}
