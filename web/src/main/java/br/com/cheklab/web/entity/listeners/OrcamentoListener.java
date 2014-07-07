package br.com.cheklab.web.entity.listeners;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import br.com.cheklab.web.entity.Orcamento;

public class OrcamentoListener {
	@PrePersist
	public void incluirOrcamentoEmAberto(Orcamento orcamento) {
		orcamento.setEmAberto(Boolean.TRUE);
		orcamento.setHoraRegistro(new Date());
		orcamento.setUltimaAtualizacao(new Date());
	}

	@PreUpdate
	public void alterarHoraAlteracao(Orcamento orcamento) {
		orcamento.setUltimaAtualizacao(new Date());
	}
}
