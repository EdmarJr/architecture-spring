package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.ConfiguracaoEndereco;

@Repository
public class ConfiguracaoEnderecoDAO extends DAO<ConfiguracaoEndereco> {

	@Override
	public Class<ConfiguracaoEndereco> getEntidade() {
		return ConfiguracaoEndereco.class;
	}

}
