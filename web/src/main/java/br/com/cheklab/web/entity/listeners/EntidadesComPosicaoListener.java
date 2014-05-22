package br.com.cheklab.web.entity.listeners;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.springframework.stereotype.Component;

import br.com.cheklab.web.entity.interfaces.EntidadeComPosicao;

@Component
public class EntidadesComPosicaoListener {

	@PrePersist
	@PreUpdate
	public void setPosicao(EntidadeComPosicao entidade) {
		if (entidade.getPosicao() == null) {
			entidade.setPosicao(Integer.valueOf(30));
		}
	}



}
