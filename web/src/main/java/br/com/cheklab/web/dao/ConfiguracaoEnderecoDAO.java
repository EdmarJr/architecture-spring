package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoEndereco;

@Repository
public class ConfiguracaoEnderecoDAO extends DAO<ConfiguracaoEndereco> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Class<ConfiguracaoEndereco> getEntidade() {
		return ConfiguracaoEndereco.class;
	}

}
