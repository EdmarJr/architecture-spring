package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.dao.EstrofePaginaInicialDAO;
import br.com.cheklab.web.entity.configuracoes.EstrofePaginaInicial;

@Service
public class EstrofePaginaInicialMediator extends
		Mediator<EstrofePaginaInicial> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private EstrofePaginaInicialDAO dao;


	@Override
	protected DAO<EstrofePaginaInicial> getDAO() {
		return dao;
	}

}
