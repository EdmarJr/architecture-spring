package br.com.cheklab.web.entity.configuracoes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.cheklab.web.entity.Imagem;
import br.com.cheklab.web.entity.interfaces.EntidadeComImagem;

@Entity
@Table(name = "configuracao")
public class Configuracao implements EntidadeComImagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;


	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_logo_menu_superior")
	private Imagem logoMenuSuperior;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Imagem getLogoMenuSuperior() {
		return logoMenuSuperior;
	}

	public void setLogoMenuSuperior(Imagem logoMenuSuperior) {
		this.logoMenuSuperior = logoMenuSuperior;
	}

	@Override
	public Imagem getImagem() {
		return getLogoMenuSuperior();
	}


}
