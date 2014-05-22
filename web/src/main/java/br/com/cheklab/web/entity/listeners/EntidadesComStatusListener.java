package br.com.cheklab.web.entity.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import br.com.cheklab.web.entity.interfaces.EntidadeComStatus;

@Component
public class EntidadesComStatusListener {

	@PrePersist
	@PreUpdate
	public void setAtivo(EntidadeComStatus entidade) {
		if (entidade.getAtivo() == null) {
			entidade.setAtivo(Boolean.TRUE);
		}
	}



}
