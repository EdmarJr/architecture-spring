package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.Configuracao;

@Repository
public class ConfiguracaoDAO extends DAO<Configuracao> {

	@Override
	public Class<Configuracao> getEntidade() {
		return Configuracao.class;
	}

}
