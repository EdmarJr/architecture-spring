package br.com.cheklab.web.entity.configuracoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cheklab.web.entity.Imagem;

@Entity
@Table(name = "configuracao_pagina_inicial")
public class ConfiguracaoPaginaInicial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToOne
	@JoinColumn(name = "id_imagem_pagina_inicial", referencedColumnName = "id")
	private Imagem imagemPaginaInicial;

	@ManyToOne
	@JoinColumn(name = "configuracao_id", referencedColumnName = "id")
	private Configuracao configuracao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Configuracao getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(Configuracao configuracao) {
		this.configuracao = configuracao;
	}

	public Imagem getPaginaInicial() {
		return imagemPaginaInicial;
	}

	public void setPaginaInicial(Imagem paginaInicial) {
		this.imagemPaginaInicial = paginaInicial;
	}

}
