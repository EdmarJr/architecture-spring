package br.com.cheklab.web.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "usuario_papeis", uniqueConstraints = @UniqueConstraint(columnNames={"papel","papel"}))
public class PapeisUsuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@ManyToOne
	@JoinColumn(name = "email", referencedColumnName="email")
	private Usuario usuario;
	@Column(name = "papel")
	private String papel;
	
}
