package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoPaginaInicial;

@Repository
public class ConfiguracaoPaginaInicialDAO extends DAO<ConfiguracaoPaginaInicial> {

	@Override
	public Class<ConfiguracaoPaginaInicial> getEntidade() {
		return ConfiguracaoPaginaInicial.class;
	}

}
