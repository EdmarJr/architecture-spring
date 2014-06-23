package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.TrabalhoRealizado;

@Repository
public class TrabalhoRealizadoDAO extends DAO<TrabalhoRealizado> {

	@Override
	public Class<TrabalhoRealizado> getEntidade() {
		return TrabalhoRealizado.class;
	}

}
