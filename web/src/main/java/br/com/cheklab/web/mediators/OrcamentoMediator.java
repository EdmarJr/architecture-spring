package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.dao.OrcamentoDAO;
import br.com.cheklab.web.entity.Orcamento;

@Service
public class OrcamentoMediator extends Mediator<Orcamento> {
	
	@Autowired
	private OrcamentoDAO dao;

	@Override
	protected DAO<Orcamento> getDAO() {
		return dao;
	}
}
