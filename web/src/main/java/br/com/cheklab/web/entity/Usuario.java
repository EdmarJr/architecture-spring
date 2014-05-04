package br.com.cheklab.web.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@Column(name = "ativo")
	private Boolean ativo;
	@OneToMany(mappedBy = "usuario")
	private List<PermissoesUsuario> roles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public List<PermissoesUsuario> getRoles() {
		return roles;
	}

	public void setRoles(List<PermissoesUsuario> roles) {
		this.roles = roles;
	}

}
