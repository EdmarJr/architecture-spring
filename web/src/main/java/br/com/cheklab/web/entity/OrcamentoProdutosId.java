package br.com.cheklab.web.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class OrcamentoProdutosId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long produtoId;
	private Long orcamentoId;

	public Long getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Long produtoId) {
		this.produtoId = produtoId;
	}

	public Long getOrcamentoId() {
		return orcamentoId;
	}

	public void setOrcamentoId(Long orcamentoId) {
		this.orcamentoId = orcamentoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((orcamentoId == null) ? 0 : orcamentoId.hashCode());
		result = prime * result
				+ ((produtoId == null) ? 0 : produtoId.hashCode());
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
		OrcamentoProdutosId other = (OrcamentoProdutosId) obj;
		if (orcamentoId == null) {
			if (other.orcamentoId != null)
				return false;
		} else if (!orcamentoId.equals(other.orcamentoId))
			return false;
		if (produtoId == null) {
			if (other.produtoId != null)
				return false;
		} else if (!produtoId.equals(other.produtoId))
			return false;
		return true;
	}

}
