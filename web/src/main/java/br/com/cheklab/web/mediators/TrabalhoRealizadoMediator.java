package br.com.cheklab.web.mediators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cheklab.web.dao.DAO;
import br.com.cheklab.web.dao.TrabalhoRealizadoDAO;
import br.com.cheklab.web.entity.TrabalhoRealizado;

@Service
public class TrabalhoRealizadoMediator extends Mediator<TrabalhoRealizado> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TrabalhoRealizadoDAO dao;


	@Override
	protected DAO<TrabalhoRealizado> getDAO() {
		return dao;
	}

}
