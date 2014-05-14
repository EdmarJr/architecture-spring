package br.com.cheklab.web.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "orcamento_has_produto")
public class OrcamentoProdutos {
	@EmbeddedId
	private OrcamentoProdutosId id;

	@ManyToOne
	@JoinColumn(name = "produto_id", referencedColumnName = "id")
	@MapsId("produtoId")
	private Produto produto;
	@ManyToOne
	@JoinColumn(name = "orcamento_id", referencedColumnName = "id")
	@MapsId("orcamentoId")
	private Orcamento orcamento;

	@Column(name = "quantidade_produtos")
	private Long quantidadeProdutos;

	public OrcamentoProdutosId getId() {
		return id;
	}

	public void setId(OrcamentoProdutosId id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public Long getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public void setQuantidadeProdutos(Long quantidadeProdutos) {
		this.quantidadeProdutos = quantidadeProdutos;
	}
	
	

}
