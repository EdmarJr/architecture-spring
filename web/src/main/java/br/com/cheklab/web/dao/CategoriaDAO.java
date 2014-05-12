package br.com.cheklab.web.dao;

import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.Categoria;

@Repository
public class CategoriaDAO extends DAO<Categoria> {



	@Override
	public Class<Categoria> getEntidade() {
		return Categoria.class;
	}
}
