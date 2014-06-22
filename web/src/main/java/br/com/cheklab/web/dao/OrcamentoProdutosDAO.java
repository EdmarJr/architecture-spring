package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.OrcamentoProdutos;

@Repository
@Transactional
public class OrcamentoProdutosDAO extends DAO<OrcamentoProdutos> {

	@Override
	public Class<OrcamentoProdutos> getEntidade() {
		return OrcamentoProdutos.class;
	}
}
