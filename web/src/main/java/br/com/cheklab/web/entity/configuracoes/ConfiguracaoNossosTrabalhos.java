package br.com.cheklab.web.entity.configuracoes;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.cheklab.web.entity.TrabalhoRealizado;

@Entity
@Table(name = "configuracao_nossos_trabalhos")
public class ConfiguracaoNossosTrabalhos implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String tituloPagina;
	private String subTituloPagina;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "configuracaoNossosTrabalhos")
	private List<TrabalhoRealizado> trabalhosRealizados;
	private String tituloRodape;
	private String subTituloRodape;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloPagina() {
		return tituloPagina;
	}

	public void setTituloPagina(String tituloPagina) {
		this.tituloPagina = tituloPagina;
	}

	public String getSubTituloPagina() {
		return subTituloPagina;
	}

	public void setSubTituloPagina(String subTituloPagina) {
		this.subTituloPagina = subTituloPagina;
	}

	public List<TrabalhoRealizado> getTrabalhosRealizados() {
		return trabalhosRealizados;
	}

	public void setTrabalhosRealizados(
			List<TrabalhoRealizado> trabalhosRealizados) {
		this.trabalhosRealizados = trabalhosRealizados;
	}

	public String getTituloRodape() {
		return tituloRodape;
	}

	public void setTituloRodape(String tituloRodape) {
		this.tituloRodape = tituloRodape;
	}

	public String getSubTituloRodape() {
		return subTituloRodape;
	}

	public void setSubTituloRodape(String subTituloRodape) {
		this.subTituloRodape = subTituloRodape;
	}

}
