package br.com.cheklab.web.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.cheklab.web.entity.Categoria;

@Repository
@Transactional
public class CategoriaDAO extends DAO<Categoria> {

	@Override
	public Class<Categoria> getEntidade() {
		return Categoria.class;
	}

	@Transactional(readOnly = true)
	public List<Categoria> obterCategoriasEFilhas() {
		Session session = abrirSessao();
		Criteria criteria = session.createCriteria(clazz);
		criteria.add(Restrictions.isNull("categoriaPai"));
		criteria.add(Restrictions.eq("ativo", true));
		@SuppressWarnings("unchecked")
		List<Categoria> categorias = criteria.list();
		for (Categoria categoria : categorias) {
			Hibernate.initialize(categoria.getCategoriasFilha());
		}
		return categorias;
	}
}
