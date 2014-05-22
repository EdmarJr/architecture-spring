package br.com.cheklab.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import br.com.cheklab.web.entity.interfaces.EntidadeComImagens;
import br.com.cheklab.web.entity.interfaces.EntidadeComPosicao;
import br.com.cheklab.web.entity.interfaces.EntidadeComStatus;
import br.com.cheklab.web.entity.listeners.EntidadesComPosicaoListener;
import br.com.cheklab.web.entity.listeners.EntidadesComStatusListener;

@Entity
@FilterDef(name = "produtoSomenteAtivos", parameters = @ParamDef(name = "ativo", type = "java.lang.Boolean"))
@Filter(name = "produtoSomenteAtivos", condition = ":ativo = ativo")
@EntityListeners({ EntidadesComStatusListener.class,
		EntidadesComPosicaoListener.class })
@Table(name = "produto")
public class Produto implements EntidadeComImagens, EntidadeComStatus,
		EntidadeComPosicao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "ativo")
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "id_categoria", referencedColumnName = "id")
	private Categoria categoria;

	@Column(name = "codigo_identificacao")
	private String codigoIdentificacao;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="produto_has_imagens",joinColumns={@JoinColumn(name="produto_id")},inverseJoinColumns={@JoinColumn(name="imagem_id")})
	private List<Imagem> imagens;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "posicao")
	private Integer posicao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getCodigoIdentificacao() {
		return codigoIdentificacao;
	}

	public void setCodigoIdentificacao(String codigoIdentificacao) {
		this.codigoIdentificacao = codigoIdentificacao;
	}

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getPosicao() {
		return posicao;
	}

	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

}
