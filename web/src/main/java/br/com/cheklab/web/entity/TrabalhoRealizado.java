package br.com.cheklab.web.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoNossosTrabalhos;
import br.com.cheklab.web.entity.interfaces.EntidadeComImagem;

@Table(name="trabalho_realizado")
@Entity
public class TrabalhoRealizado implements Serializable, EntidadeComImagem {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	private String nomeCliente;
	@OneToOne
	@JoinColumn(name="imagem_trabalho",referencedColumnName="id")
	private Imagem imagemTrabalho;
	@Column(length = 5000)
	private String descricaoTrabalho1;
	@Column(length = 5000)
	private String descricaoTrabalho2;
	private String caracteristica1;
	private String caracteristica2;
	private String caracteristica3;
	@ManyToOne
	@JoinColumn(referencedColumnName="id",name="configuracaoNossosTrabalhos_id")
	private ConfiguracaoNossosTrabalhos configuracaoNossosTrabalhos;
	
	
	
	public ConfiguracaoNossosTrabalhos getConfiguracaoNossosTrabalhos() {
		return configuracaoNossosTrabalhos;
	}

	public void setConfiguracaoNossosTrabalhos(
			ConfiguracaoNossosTrabalhos configuracaoNossosTrabalhos) {
		this.configuracaoNossosTrabalhos = configuracaoNossosTrabalhos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imagem getImagemTrabalho() {
		return imagemTrabalho;
	}

	public void setImagemTrabalho(Imagem imagemTrabalho) {
		this.imagemTrabalho = imagemTrabalho;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	public String getDescricaoTrabalho1() {
		return descricaoTrabalho1;
	}
	public void setDescricaoTrabalho1(String descricaoTrabalho1) {
		this.descricaoTrabalho1 = descricaoTrabalho1;
	}
	public String getDescricaoTrabalho2() {
		return descricaoTrabalho2;
	}
	public void setDescricaoTrabalho2(String descricaoTrabalho2) {
		this.descricaoTrabalho2 = descricaoTrabalho2;
	}
	public String getCaracteristica1() {
		return caracteristica1;
	}
	public void setCaracteristica1(String caracteristica1) {
		this.caracteristica1 = caracteristica1;
	}
	public String getCaracteristica2() {
		return caracteristica2;
	}
	public void setCaracteristica2(String caracteristica2) {
		this.caracteristica2 = caracteristica2;
	}
	public String getCaracteristica3() {
		return caracteristica3;
	}
	public void setCaracteristica3(String caracteristica3) {
		this.caracteristica3 = caracteristica3;
	}

	@Override
	public Imagem getImagem() {
		return getImagemTrabalho();
	}
	
	
}
