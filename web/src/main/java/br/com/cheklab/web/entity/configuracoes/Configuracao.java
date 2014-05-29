package br.com.cheklab.web.entity.configuracoes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.entity.interfaces.EntidadeComImagem;

@Entity
@Table(name = "configuracao")
public class Configuracao implements EntidadeComImagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToMany(mappedBy = "configuracao")
	private List<ConfiguracaoPaginaInicial> configuracoesPaginaInicial;
	@OneToMany(mappedBy = "configuracao")
	private List<ConfiguracaoPaginaProdutos> configuracoesPaginaProdutos;
	@OneToMany(mappedBy = "configuracao")
	private List<ConfiguracaoOrcamento> configuracoesOrcamentos;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_logo_menu_superior")
	private Imagem logoMenuSuperior;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ConfiguracaoPaginaInicial> getConfiguracoesPaginaInicial() {
		return configuracoesPaginaInicial;
	}

	public void setConfiguracoesPaginaInicial(
			List<ConfiguracaoPaginaInicial> configuracoesPaginaInicial) {
		this.configuracoesPaginaInicial = configuracoesPaginaInicial;
	}

	public List<ConfiguracaoPaginaProdutos> getConfiguracoesPaginaProdutos() {
		return configuracoesPaginaProdutos;
	}

	public void setConfiguracoesPaginaProdutos(
			List<ConfiguracaoPaginaProdutos> configuracoesPaginaProdutos) {
		this.configuracoesPaginaProdutos = configuracoesPaginaProdutos;
	}

	public List<ConfiguracaoOrcamento> getConfiguracoesOrcamentos() {
		return configuracoesOrcamentos;
	}

	public void setConfiguracoesOrcamentos(
			List<ConfiguracaoOrcamento> configuracoesOrcamentos) {
		this.configuracoesOrcamentos = configuracoesOrcamentos;
	}

	public Imagem getLogoMenuSuperior() {
		return logoMenuSuperior;
	}

	public void setLogoMenuSuperior(Imagem logoMenuSuperior) {
		this.logoMenuSuperior = logoMenuSuperior;
	}

	@Override
	public Imagem getImagem() {
		return getLogoMenuSuperior();
	}


}
