package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.configuracoes.EstrofePaginaInicial;

@Repository
public class EstrofePaginaInicialDAO extends DAO<EstrofePaginaInicial> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public Class<EstrofePaginaInicial> getEntidade() {
		return EstrofePaginaInicial.class;
	}

}
