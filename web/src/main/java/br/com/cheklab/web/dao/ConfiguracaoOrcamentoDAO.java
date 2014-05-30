package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoOrcamento;

@Repository
public class ConfiguracaoOrcamentoDAO extends DAO<ConfiguracaoOrcamento> {

	@Override
	public Class<ConfiguracaoOrcamento> getEntidade() {
		return ConfiguracaoOrcamento.class;
	}

}
