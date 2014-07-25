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
import javax.persistence.OneToMany;
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
@FilterDef(name = "categoriaSomenteAtivos", parameters = @ParamDef(name = "ativo", type = "java.lang.Boolean"))
@Filter(name = "categoriaSomenteAtivos", condition = ":ativo = ativo")
@EntityListeners({ EntidadesComStatusListener.class,
		EntidadesComPosicaoListener.class })
@Table(name = "categoria")
public class Categoria implements EntidadeComImagens, EntidadeComStatus,
		EntidadeComPosicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "posicao")
	private Integer posicao;

	@Column(name = "ativo")
	private Boolean ativo;
	@ManyToOne
	@JoinColumn(name = "id_categoria_pai", referencedColumnName = "id")
	private Categoria categoriaPai;

	@OneToMany(mappedBy = "categoriaPai")
	private List<Categoria> categoriasFilha;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="categoria_has_imagens",joinColumns={@JoinColumn(name="categoria_id")},inverseJoinColumns={@JoinColumn(name="imagem_id")})
	private List<Imagem> imagens;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Categoria getCategoriaPai() {
		return categoriaPai;
	}

	public void setCategoriaPai(Categoria categoriaPai) {
		this.categoriaPai = categoriaPai;
	}

	public List<Categoria> getCategoriasFilha() {
		return categoriasFilha;
	}

	public void setCategoriasFilha(List<Categoria> categoriasFilha) {
		this.categoriasFilha = categoriasFilha;
	}

	@Override
	public Integer getPosicao() {
		return posicao;
	}

	@Override
	public void setPosicao(Integer posicao) {
		this.posicao = posicao;
	}

	@Override
	public Boolean getAtivo() {
		return ativo;
	}

	@Override
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
