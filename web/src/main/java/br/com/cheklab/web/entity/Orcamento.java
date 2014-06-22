package br.com.cheklab.web.entity;

import java.util.Date;
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
@Table(name = "orcamento")
public class Orcamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@OneToMany(mappedBy = "orcamento")
	private List<OrcamentoProdutos> produtosOrcamento;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "id_cliente", referencedColumnName = "id")
	private Cliente cliente;
	
	@Column(name = "emAberto")
	private Boolean emAberto;

	@Column(name = "horaRegistro")
	private Date horaRegistro;

	@Column(name = "horaUltimaAtualizacao")
	private Date ultimaAtualizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<OrcamentoProdutos> getProdutosOrcamento() {
		return produtosOrcamento;
	}

	public void setProdutosOrcamento(List<OrcamentoProdutos> produtosOrcamento) {
		this.produtosOrcamento = produtosOrcamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Boolean getEmAberto() {
		return emAberto;
	}

	public void setEmAberto(Boolean emAberto) {
		this.emAberto = emAberto;
	}

	public Date getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(Date horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	public Date getUltimaAtualizacao() {
		return ultimaAtualizacao;
	}

	public void setUltimaAtualizacao(Date ultimaAtualizacao) {
		this.ultimaAtualizacao = ultimaAtualizacao;
	}

}
