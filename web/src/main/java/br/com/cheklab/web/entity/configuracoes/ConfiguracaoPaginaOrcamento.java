package br.com.cheklab.web.entity.configuracoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "configuracao_orcamento")
public class ConfiguracaoPaginaOrcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "configuracao_id", referencedColumnName = "id")
	private Configuracao configuracao;

	@Column(name = "indicacao_habilitada")
	private Boolean indicacaoHabilitada;

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

	public Boolean getIndicacaoHabilitada() {
		return indicacaoHabilitada;
	}

	public void setIndicacaoHabilitada(Boolean indicacaoHabilitada) {
		this.indicacaoHabilitada = indicacaoHabilitada;
	}

}
