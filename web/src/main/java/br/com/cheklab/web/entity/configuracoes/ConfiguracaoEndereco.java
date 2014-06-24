package br.com.cheklab.web.entity.configuracoes;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "configuracao_endereco")
public class ConfiguracaoEndereco extends ConfiguracaoGeneric implements
		Serializable {
	
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private static final long serialVersionUID = 1L;
	private String tituloJanelaEndereco;
	private String texto1;
	private String texto2;
	private String texto3;
	private String texto4;
	private String texto5;
	private String enderecoGoogleMaps;
	private String tituloBotao;
	
	public String getTituloJanelaEndereco() {
		return tituloJanelaEndereco;
	}
	public void setTituloJanelaEndereco(String tituloJanelaEndereco) {
		this.tituloJanelaEndereco = tituloJanelaEndereco;
	}
	public String getTexto1() {
		return texto1;
	}
	public void setTexto1(String texto1) {
		this.texto1 = texto1;
	}
	public String getTexto2() {
		return texto2;
	}
	public void setTexto2(String texto2) {
		this.texto2 = texto2;
	}
	public String getTexto3() {
		return texto3;
	}
	public void setTexto3(String texto3) {
		this.texto3 = texto3;
	}
	public String getTexto4() {
		return texto4;
	}
	public void setTexto4(String texto4) {
		this.texto4 = texto4;
	}
	public String getEnderecoGoogleMaps() {
		return enderecoGoogleMaps;
	}
	public void setEnderecoGoogleMaps(String enderecoGoogleMaps) {
		this.enderecoGoogleMaps = enderecoGoogleMaps;
	}
	public String getTituloBotao() {
		return tituloBotao;
	}
	public void setTituloBotao(String tituloBotao) {
		this.tituloBotao = tituloBotao;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTexto5() {
		return texto5;
	}
	public void setTexto5(String texto5) {
		this.texto5 = texto5;
	}
	
	
	
}
