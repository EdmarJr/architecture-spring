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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.entity.TrabalhoRealizado;
import br.com.cheklab.web.entity.interfaces.EntidadeComImagem;
import br.com.cheklab.web.entity.interfaces.EntidadeComImagens;

@Entity
@Table(name = "configuracao_pagina_inicial")
public class ConfiguracaoPaginaInicial extends ConfiguracaoGeneric implements
		Serializable, EntidadeComImagens, EntidadeComImagem {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	private String textoImagem;

	@OneToOne
	@JoinColumn(name = "id_imagem_pagina_inicial", referencedColumnName = "id")
	private Imagem imagemPaginaInicial;

	@OneToMany(mappedBy = "configuracaoPaginaInicial", fetch = FetchType.EAGER)
	private List<EstrofePaginaInicial> estrofes;
	@ManyToMany
	@JoinTable(name = "configuracaoPaginaInicial_has_trabalhoRealizado", joinColumns = { @JoinColumn(name = "configuracao_pagina_inicial_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "trabalho_realizado_id", referencedColumnName = "id") })
	private List<TrabalhoRealizado> ultimosTrabalhos;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "configuracaoPaginaInicial_has_imagensClientes", joinColumns = { @JoinColumn(referencedColumnName = "id", name = "configuracao_pagina_inicial_id") }, inverseJoinColumns = { @JoinColumn(referencedColumnName = "id", name = "imagem_cliente_id") })
	private List<Imagem> imagensPrincipaisClientes;
	private String tituloTexto1;
	@Column(length = 5000)
	private String texto1;
	private String tituloTexto2;
	@Column(length = 5000)
	private String texto2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imagem getPaginaInicial() {
		return imagemPaginaInicial;
	}

	public void setPaginaInicial(Imagem paginaInicial) {
		this.imagemPaginaInicial = paginaInicial;
	}



	public String getTextoImagem() {
		return textoImagem;
	}

	public void setTextoImagem(String textoImagem) {
		this.textoImagem = textoImagem;
	}

	public Imagem getImagemPaginaInicial() {
		return imagemPaginaInicial;
	}

	public void setImagemPaginaInicial(Imagem imagemPaginaInicial) {
		this.imagemPaginaInicial = imagemPaginaInicial;
	}

	public List<EstrofePaginaInicial> getEstrofes() {
		return estrofes;
	}

	public void setEstrofes(List<EstrofePaginaInicial> estrofes) {
		this.estrofes = estrofes;
	}

	public List<TrabalhoRealizado> getUltimosTrabalhos() {
		return ultimosTrabalhos;
	}

	public void setUltimosTrabalhos(List<TrabalhoRealizado> ultimosTrabalhos) {
		this.ultimosTrabalhos = ultimosTrabalhos;
	}

	public List<Imagem> getImagensPrincipaisClientes() {
		return imagensPrincipaisClientes;
	}

	public void setImagensPrincipaisClientes(
			List<Imagem> imagensPrincipaisClientes) {
		this.imagensPrincipaisClientes = imagensPrincipaisClientes;
	}

	public String getTituloTexto1() {
		return tituloTexto1;
	}

	public void setTituloTexto1(String tituloTexto1) {
		this.tituloTexto1 = tituloTexto1;
	}

	public String getTexto1() {
		return texto1;
	}

	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}

	public String getTituloTexto2() {
		return tituloTexto2;
	}

	public void setTituloTexto2(String tituloTexto2) {
		this.tituloTexto2 = tituloTexto2;
	}

	public String getTexto2() {
		return texto2;
	}

	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}

	@Override
	public List<Imagem> getImagens() {
		return getImagensPrincipaisClientes();
	}

	@Override
	public Imagem getImagem() {
		return getImagemPaginaInicial();
	}


}
