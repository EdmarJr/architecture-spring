package br.com.cheklab.web.dao;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.configuracoes.Configuracao;

@Repository
public class ConfiguracaoDAO extends DAO<Configuracao> {

	@Override
	public Class<Configuracao> getEntidade() {
		return Configuracao.class;
	}

	@Transactional(readOnly = true)
	public Configuracao obterConfiguracaoCarregadaPorId(Long id) {
		Configuracao configuracao = buscarPorId(id);
		Hibernate.initialize(configuracao.getConfiguracoesOrcamentos());
		Hibernate.initialize(configuracao.getConfiguracoesPaginaInicial());
		Hibernate.initialize(configuracao.getConfiguracoesPaginaProdutos());
		return configuracao;

	}

}
