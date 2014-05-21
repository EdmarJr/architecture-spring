package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Orcamento;

@Repository
@Transactional
public class OrcamentoDAO extends DAO<Orcamento> {

	@Override
	public Class<Orcamento> getEntidade() {
		return Orcamento.class;
	}
}
