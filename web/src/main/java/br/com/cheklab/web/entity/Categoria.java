package br.com.cheklab.web.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "posicao")
	private Integer posicaoApresentacao;

	@Column(name = "descricao")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_categoria_pai", referencedColumnName = "id")
	private Categoria categoriaPai;

	@OneToMany(mappedBy = "categoriaPai")
	private List<Categoria> categoriasFilha;

	@OneToMany(mappedBy = "categoria")
	private List<Produto> produtos;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
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

	public List<Imagem> getImagens() {
		return imagens;
	}

	public void setImagens(List<Imagem> imagens) {
		this.imagens = imagens;
	}

	public Integer getPosicaoApresentacao() {
		return posicaoApresentacao;
	}

	public void setPosicaoApresentacao(Integer posicaoApresentacao) {
		this.posicaoApresentacao = posicaoApresentacao;
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

}
