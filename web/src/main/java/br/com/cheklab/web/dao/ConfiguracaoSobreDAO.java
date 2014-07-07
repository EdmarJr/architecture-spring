package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoSobre;

@Repository
public class ConfiguracaoSobreDAO extends DAO<ConfiguracaoSobre> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Class<ConfiguracaoSobre> getEntidade() {
		return ConfiguracaoSobre.class;
	}

}
