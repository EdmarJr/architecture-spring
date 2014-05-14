package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.Orcamento;

@Repository
public class OrcamentoDAO extends DAO<Orcamento> {

	@Override
	public Class<Orcamento> getEntidade() {
		return Orcamento.class;
	}
}
