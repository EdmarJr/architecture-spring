package br.com.cheklab.web.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import br.com.cheklab.web.entity.interfaces.EntidadeComPosicao;
import br.com.cheklab.web.entity.interfaces.EntidadeComStatus;
import br.com.cheklab.web.entity.listeners.ConversorImagemListener;
import br.com.cheklab.web.entity.listeners.EntidadesComPosicaoListener;
import br.com.cheklab.web.entity.listeners.EntidadesComStatusListener;

@Entity
@FilterDef(name = "imagemSomenteAtivos", parameters = @ParamDef(name = "ativo", type = "java.lang.Boolean"))
@Filter(name = "imagemSomenteAtivos", condition = ":ativo = ativo")
@EntityListeners({ ConversorImagemListener.class,
		EntidadesComStatusListener.class, EntidadesComPosicaoListener.class })
@Table(name = "imagem")
public class Imagem implements EntidadeComStatus, EntidadeComPosicao {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "nome")
	private String nome;

	@Column(name = "endereco")
	private String endereco;

	@Column(name = "endereco_miniatura")
	private String enderecoMiniatura;

	@Column(name = "descricao")
	private String descricao;
	@Column(name = "posicao")
	private Integer posicao;

	@Column(name = "ativo")
	private Boolean ativo;
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(columnDefinition="BLOB NOT NULL", length=10485760)
	private byte[] miniaturaBlob;
	@Lob @Basic(fetch=FetchType.LAZY)
	@Column(columnDefinition="BLOB NOT NULL", length=10485760)
	private byte[] maiorBlob;

	@Transient
	private Long idEntidade;
	@Transient
	private String tipoEntidade;

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

	public String getEndereco() {
		return endereco;
	}

	public String getEnderecoSeparator() {
		if (endereco != null) {
			return endereco.replaceAll("\\\\", "/");
		}
		return null;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	

	public byte[] getMiniaturaBlob() {
		return miniaturaBlob;
	}

	public void setMiniaturaBlob(byte[] miniaturaBlob) {
		this.miniaturaBlob = miniaturaBlob;
	}

	public byte[] getMaiorBlob() {
		return maiorBlob;
	}

	public void setMaiorBlob(byte[] maiorBlob) {
		this.maiorBlob = maiorBlob;
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

	public String getEnderecoMiniatura() {
		return enderecoMiniatura;
	}

	public String getEnderecoMiniaturaSeparator() {
		if (enderecoMiniatura != null) {
			return enderecoMiniatura.replaceAll("\\\\", "/");
		}
		return null;
	}

	public void setEnderecoMiniatura(String enderecoMiniatura) {
		this.enderecoMiniatura = enderecoMiniatura;
	}

	public Long getIdEntidade() {
		return idEntidade;
	}

	public void setIdEntidade(Long idEntidade) {
		this.idEntidade = idEntidade;
	}

	public String getTipoEntidade() {
		return tipoEntidade;
	}

	public void setTipoEntidade(String tipoEntidade) {
		this.tipoEntidade = tipoEntidade;
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
		Imagem other = (Imagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
