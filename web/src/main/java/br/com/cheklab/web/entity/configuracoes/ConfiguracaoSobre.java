package br.com.cheklab.web.entity.configuracoes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuracao_sobre")
public class ConfiguracaoSobre extends ConfiguracaoGeneric implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(length = 10000, name = "textoPagina")
	private String textoPagina;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTextoPagina() {
		return textoPagina;
	}

	public void setTextoPagina(String textoPagina) {
		this.textoPagina = textoPagina;
	}

}
