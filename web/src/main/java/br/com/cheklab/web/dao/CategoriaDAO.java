package br.com.cheklab.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.cheklab.web.entity.Categoria;

@Repository
public class CategoriaDAO extends DAO<Categoria> {

	@Override
	public Class<Categoria> getEntidade() {
		return Categoria.class;
	}

	public List<Categoria> obterCategoriasEFilhas() {
		Session session = abrirSessao();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.isNull("categoriaPai"));
		@SuppressWarnings("unchecked")
		List<Categoria> categorias = criteria.list();
		for (Categoria categoria : categorias) {
			Hibernate.initialize(categoria.getCategoriasFilha());
		}
		session.close();
		return categorias;
	}
}
