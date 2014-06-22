package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaOrcamento;

@Repository
public class ConfiguracaoOrcamentoDAO extends DAO<ConfiguracaoPaginaOrcamento> {

	@Override
	public Class<ConfiguracaoPaginaOrcamento> getEntidade() {
		return ConfiguracaoPaginaOrcamento.class;
	}

}
