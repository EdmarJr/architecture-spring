package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoNossosTrabalhos;

@Repository
public class ConfiguracaoNossosTrabalhosDAO extends DAO<ConfiguracaoNossosTrabalhos> {

	@Override
	public Class<ConfiguracaoNossosTrabalhos> getEntidade() {
		return ConfiguracaoNossosTrabalhos.class;
	}

}
