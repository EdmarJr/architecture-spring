package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaProdutos;

@Repository
public class ConfiguracaoPaginaProdutosDAO extends DAO<ConfiguracaoPaginaProdutos> {

	@Override
	public Class<ConfiguracaoPaginaProdutos> getEntidade() {
		return ConfiguracaoPaginaProdutos.class;
	}

}
